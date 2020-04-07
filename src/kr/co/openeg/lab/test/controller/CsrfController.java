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
public class CsrfController {
	
	static int count;
	
	@Resource(name="memberService")
	private MemberService service;
	
	@Resource(name="testService")
	private TestService testService;
	
	
	
	
	
	
	
	// CSRF 테스트 
	@RequestMapping(value="/test/csrf_test.do")
	@ResponseBody
	public String testCSRF(HttpServletRequest request) {
		StringBuffer buffer=new StringBuffer();
		String data=request.getParameter("id");
	    MemberModel   m=service.findMember(data);
		//buffer.append("<font color='pink' size='8'>");
		buffer.append("<p>사용자ID: "+m.getUserId()+"</p>");
		buffer.append("<p>이메일: "+m.getUserName()+"</p>");
		buffer.append("<p>PIN NO: "+m.getPinNo()+"</p>");
		//buffer.append("</font>");
        return buffer.toString();	
	}
	
	
	// CSRF 테스트 
	@RequestMapping(value="/test/csrf_test.do", method = RequestMethod.POST)
	@ResponseBody
	public String testCSRF2(HttpServletRequest request) {
		StringBuffer buffer=new StringBuffer();
		String data=request.getParameter("id");
		buffer.append(data);
        return buffer.toString();	
	}
	
	

}
