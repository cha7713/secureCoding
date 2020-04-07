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
public class EncapController {
	
	static int count;
	
	@Resource(name="memberService")
	private MemberService service;
	
	@Resource(name="testService")
	private TestService testService;
	

	
	
	
	// 캡슐화 위배
	@RequestMapping(value="/test/encap_test.do", method = RequestMethod.POST )
	@ResponseBody
	public String testEncapsulation(HttpServletRequest request){
	    StringBuffer buffer=new StringBuffer();			
	    Role role=Role.getInstance();
	    String data=request.getParameter("data");
	    String type=request.getParameter("type");
	    switch(TestUtil.getInt(type)){
	    case 0:
	    	        buffer.append(role.adminLists());
	    	        break;
	    case 1:
	    	        String[] list = role.getAdminRoles();
	    	        list[0]=data;
	    	        buffer.append(role.adminLists());
	    	        break;
	    case 2:
	        String[] users=data.split(",");
	        role.setAdminRoles(users);
	        buffer.append("새로 설정된 관리자 목록: "+role.adminLists()+"<br/>");        
	        users[0]="hacker";
	        buffer.append("위조된 관리자 목록: "+role.adminLists());
	        break;
	    default:
	    }
        return buffer.toString();	
	}
	// 캡슐화 위배
		@RequestMapping(value="/test/encap_test.do", method = RequestMethod.GET )
		public String testEncapsulation(HttpServletRequest request, Model model){
		    StringBuffer buffer=new StringBuffer();			
		    Role role=Role.getInstance();
		    String data=request.getParameter("data");
		    String type=request.getParameter("type");
		    switch(TestUtil.getInt(type)){
		    case 0:
		    	        buffer.append(role.adminLists());
		    	        break;
		    case 1:
		    	        String[] list = role.getAdminRoles();
		    	        list[0]=data;
		    	        buffer.append(role.adminLists());
		    	        break;
		    case 2:
		        String[] users=data.split(",");
		        role.setAdminRoles(users);
		        buffer.append("새로 설정된 관리자 목록: "+role.adminLists()+"<br/>");        
		        users[0]="hacker";
		        buffer.append("위조된 관리자 목록: "+role.adminLists());
		        break;
		    default:
		    }
		    model.addAttribute("result", buffer.toString());
	        return "test/test_encap";	
		}
	
	


}
