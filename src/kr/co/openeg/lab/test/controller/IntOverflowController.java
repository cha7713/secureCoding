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
public class IntOverflowController {
	
	static int count;
	
	@Resource(name="memberService")
	private MemberService service;
	
	@Resource(name="testService")
	private TestService testService;
	
	
	// 정수 오버플로우 
	@RequestMapping(value="/test/int_overflow_test.do", method = RequestMethod.POST)
	@ResponseBody
	public String testIntOverflow(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer buffer=new StringBuffer();
		String data=request.getParameter("data");
		System.out.println("수신데이터: "+data);
		int size=Integer.parseInt(data);
		String[] strings = new String[size+1];
        strings[0]="hello";
        buffer.append(strings[0]+"  int overflow test");    
	    return buffer.toString();
	}
	
	// 정수 오버플로우 
	@RequestMapping(value="/test/int_overflow_test.do", method = RequestMethod.GET)
	public String testIntOverflow(HttpServletRequest request, HttpServletResponse response, Model model) {
		StringBuffer buffer=new StringBuffer();
		String data=request.getParameter("data");
		System.out.println("수신데이터: "+data);
		try {
			int size=Integer.parseInt(data);
			String[] strings = new String[size+1];
			strings[0]="hello";
			buffer.append(strings[0]+"  int overflow test");    
			
		} catch (Exception e) {
			// TODO: handle exception
			buffer.append("요청처리 실패");  
		}
        model.addAttribute("result", buffer.toString());
	    return "test/test_int_overflow";
	}
	

}
