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
public class XSSController {
	
	static int count;
	
	@Resource(name="memberService")
	private MemberService service;
	
	@Resource(name="testService")
	private TestService testService;
	
	
	// Reflective XSS 테스트 
	@RequestMapping(value="/test/xss_test.do", method = RequestMethod.POST)
	@ResponseBody
	public String testXss(HttpServletRequest request) {
		StringBuffer buffer=new StringBuffer();
		String data=request.getParameter("data");
		buffer.append(data);
        return buffer.toString();	
	}
	// Reflective XSS 테스트 
		@RequestMapping(value="/test/xss_test.do", method = RequestMethod.GET)
		public String testXss(HttpServletRequest request,Model model) {
			StringBuffer buffer=new StringBuffer();
			String data=request.getParameter("data");
			buffer.append(data);
			model.addAttribute("result", buffer.toString());
	        return "/test/test_xss";
		}
	
	
	// Stored XSS 테스트 
	@RequestMapping(value="/test/xss_test_b.do", method = RequestMethod.POST)
	@ResponseBody
	public String testXssB(HttpServletRequest request) {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("1", "<script>alert('xss');</script>");
        map.put("2", "&lt;script&gt;alert('xss');&lt;/script&gt;");
		StringBuffer buffer=new StringBuffer();
		String data=request.getParameter("data");
		if ("1".equals(data)) {
			buffer.append(map.get("1"));
		}else if ( "2".equals(data)) {
			buffer.append(map.get("2"));
		} else {
			buffer.append("잘못된 요청입니다.");
		}
        return buffer.toString();	
	}
	// Stored XSS 테스트 
		@RequestMapping(value="/test/xss_test_b.do", method = RequestMethod.GET)
		public String testXssB(HttpServletRequest request, Model model) {
	        HashMap<String,String> map = new HashMap<String,String>();
	        map.put("1", "<script>alert('xss');</script>");
	        map.put("2", "&lt;script&gt;alert('xss');&lt;/script&gt;");
			StringBuffer buffer=new StringBuffer();
			String data=request.getParameter("data");
			if ("1".equals(data)) {
				buffer.append(map.get("1"));
			}else if ( "2".equals(data)) {
				buffer.append(map.get("2"));
			} else {
				buffer.append("잘못된 요청입니다.");
			}
			model.addAttribute("result", buffer.toString());
	        return "/test/test_xss";	
		}
	
	// DOM XSS 테스트 
	@RequestMapping(value="/test/xss_test_c.do")
	public void testXssC(HttpServletRequest request, HttpServletResponse response) {
		String data=request.getParameter("data");
        try {
	         response.sendRedirect("../domxss.jsp?message="+data);
        } catch (IOException e) {
	
          System.out.println("ERROR");
        }
	}
	


}
