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
public class NullController {
	
	static int count;
	
	@Resource(name="memberService")
	private MemberService service;
	
	@Resource(name="testService")
	private TestService testService;
	
	
	
	// 널포인트 역참조
	@RequestMapping(value="/test/null_test.do")
	@ResponseBody
	public String testNull(HttpServletRequest request, HttpSession session){
		    StringBuffer buffer=new StringBuffer();			
	        String data=request.getParameter("data");
	        String userid=request.getParameter("userid");
	        try {
		        FileReader fr=new FileReader("c:/SecureCoding/eclipse/eclipse.ini");	
		        if( userid.equals("admin")) {
		        	switch(TestUtil.getInt(data)){
		        	case 0: buffer.append("백업 작업을 수행합니다."); break;
		        	case 1: buffer.append("복구 작업을 수행합니다."); break;
		        	case 2: buffer.append("실행 작업을 수행합니다."); break;
		        	default: buffer.append("선택된 작업이 없습니다.");
		        	}
		        } else {
		        	buffer.append("작업권한이 없습니다.");
		        }
	        }catch(Exception e) {
	        	buffer.append("파일 초기화 작업을 수행합니다."); 
	        }
		 
        return buffer.toString();	
	}


}
