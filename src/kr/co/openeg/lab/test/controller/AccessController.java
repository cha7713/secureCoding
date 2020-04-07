package kr.co.openeg.lab.test.controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.org.apache.xpath.internal.operations.Mod;

import kr.co.openeg.lab.member.model.MemberModel;
import kr.co.openeg.lab.member.service.MemberService;
import kr.co.openeg.lab.test.util.Customer;
import kr.co.openeg.lab.test.util.CustomerService;
import kr.co.openeg.lab.test.util.DBinit;
import kr.co.openeg.lab.test.util.Role;
import kr.co.openeg.lab.test.util.TestUtil;




@Controller
public class AccessController {
	
	static int count;
	
	@Resource(name="memberService")
	private MemberService service;
	
	@Resource(name="testService")
	private TestService testService;
	
    
	// 접근제어 
	@RequestMapping(value="/test/access_control_test.do", method = RequestMethod.POST)
	@ResponseBody
	public String testAccessControlPost(HttpServletRequest request,HttpServletResponse response,
	                                    HttpSession session){			
	 StringBuffer buffer=new StringBuffer(); 
	 MemberModel m=null;
	 String id=request.getParameter("id");
	 String name = request.getParameter("name");
	 String action=request.getParameter("action");
	
	 // 사용자정보 조회 요청인 경우 DB에서 해당 사용자 정보를 조회한 결과를 응답
	 if( "view".equals(action)) {
	   if( id != null && ! "".equals(id)) {
	       m=service.findMember(id);
	       if(m==null) {
		      buffer.append("등록되지 않은 사용자입니다. ");
	       } else {
	          // 조회한 사용자 정보는 세션에 저장
		     session.setAttribute("member", m);
		     buffer.append("사용자ID: "+m.getUserId()+"<br/>");
		     buffer.append("고객명: "+m.getUserName()+"<br/>");
		     buffer.append("전화번호: "+m.getPinNo()+"<br/>");
		     buffer.append("가입일자: "+m.getJoinDate()+"<br/>"); 
	       }
	   }else{
	       buffer.append("userId가 입력되지 않았습니다.");
	   }
	
	   // 실행결과 사용자에 대한 고객 정보 수정
	 } else if( "modify".equals(action)) {
	   m=(MemberModel)session.getAttribute("member");
	   if(m==null) {
	       buffer.append("사용자정보 조회부터 실행하세요");
	   } else {
	       m.setPinNo(name);
	       service.modifyMember(m);
	       session.setAttribute("member", m);
	         buffer.append(m.getUserId()+"님의 고객번호 수정을 완료하였습니다.<br/>");   
		     buffer.append("사용자ID: "+m.getUserId()+"<br/>");
		     buffer.append("고객명: "+m.getUserName()+"<br/>");
		     buffer.append("전화번호: "+m.getPinNo()+"<br/>");
		     buffer.append("가입일자: "+m.getJoinDate()+"<br/>"); 
	    }

	   // 실행결과 사용자에 대한 고객정보 삭제
	 }else if ( "delete".equals(action)) {
	      m=(MemberModel)session.getAttribute("member");
	      if(m==null) {
		      buffer.append("사용자정보 조회부터 실행하세요");
	      } else {				
		service.deleteMember(m);
		session.removeAttribute("member");
		buffer.append(m.getUserId()+"님의  정보를 삭제하였습니다.");
	      }
	      
	  // 새로운 고객 정보 등록
	 }else if ( "edit".equals(action)) {
	    if( id != null && ! "".equals(id)) {
	        m=new MemberModel(0,id,id,name,"","");
	        int result=service.addMember(m);       
	        if ( result == 3) {
	        	 m=service.findMember(id);
	        	 if ( m != null) {    
	        		 session.setAttribute("member", m);
			         buffer.append(m.getUserId()+" 사용자 등록을 완료하였습니다.<br/>");   
				     buffer.append("사용자ID: "+m.getUserId()+"<br/>");
				     buffer.append("고객명: "+m.getUserName()+"<br/>");
				     buffer.append("전화번호: "+m.getPinNo()+"<br/>");
				     buffer.append("가입일자: "+m.getJoinDate()+"<br/>"); 
	        	 } else {
	        		 buffer.append("사용자 등록 실패: "+result);
	        	 }
	        } else {
		        buffer.append("사용자 등록 실패: "+result);
	        }
	    }else {
	         buffer.append("userId가 입력되지 않았습니다.");
	    }
	 }	
	 return buffer.toString();
	}

	

}
