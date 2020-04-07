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
public class HttpSplitController {
	
	static int count;
	
	@Resource(name="memberService")
	private MemberService service;
	
	@Resource(name="testService")
	private TestService testService;
	

	// HTTP 응답분할 
	@RequestMapping(value="/test/http_split_test.do", method = RequestMethod.POST)
	@ResponseBody
	public String testHttpSplit(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer buffer=new StringBuffer();
		String data=request.getParameter("data");
		System.out.println("수신된 데이터: "+data);
		response.setHeader("openeg", data);
//		Cookie cookie=new Cookie("data",data);
//		response.addCookie(cookie);
		buffer.append("HTTP 응답 분할 테스트: Cookie 값 확인");
	    return buffer.toString();
	}
	
	// HTTP 응답분할 
		@RequestMapping(value="/test/http_split_test.do", method = RequestMethod.GET)
		public String testHttpSplit(HttpServletRequest request, HttpServletResponse response, Model model) {
			StringBuffer buffer=new StringBuffer();
			String data=request.getParameter("data");
			System.out.println("수신된 데이터: "+data);
			response.setHeader("openeg", data);
//			Cookie cookie=new Cookie("data",data);
//			response.addCookie(cookie);
			buffer.append("HTTP 응답 분할 테스트: Cookie 값 확인");
			model.addAttribute("result", buffer.toString());
		    return "test/test_http_split";
		}
	
	


}
