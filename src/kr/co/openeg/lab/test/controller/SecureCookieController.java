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
public class SecureCookieController {
	
	static int count;
	
	@Resource(name="memberService")
	private MemberService service;
	
	@Resource(name="testService")
	private TestService testService;
	


	// Secure Cookie
	@RequestMapping(value="/test/secure_cookie_test.do", method = RequestMethod.POST)
	@ResponseBody
	public String testSecureCookie(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer buffer=new StringBuffer();
		String data=request.getParameter("data");
		String type=request.getParameter("type");
		switch( Integer.parseInt(type)) {
		case 0:
			Cookie c=new Cookie("openeg",data);
			// 쿠키에 보안 설정 CODE 삽입
			c.setMaxAge(60*60*24*365);            // 쿠키 유지 기간 - 1년
			c.setPath("/"); 
			response.addCookie(c);
			buffer.append("openeg="+data +"  쿠키값 추가");
			break;
		case 1:
			Cookie[] cookies = request.getCookies();
			buffer.append("수신된 쿠키<br/>");
			for (int i = 0; i < cookies.length; i++) {
			    buffer.append(cookies[i].getName() +"=");
			    buffer.append(cookies[i].getValue() + "<br/>");
			}
			break;
		default:
			buffer.append("요청오류");
			break;
		}

        return buffer.toString();		
	}
	
	// Secure Cookie
		@RequestMapping(value="/test/secure_cookie_test.do", method = RequestMethod.GET)
		public String testSecureCookie(HttpServletRequest request, HttpServletResponse response, Model model) {
			StringBuffer buffer=new StringBuffer();
			String data=request.getParameter("data");
			String type=request.getParameter("type");
			switch( Integer.parseInt(type)) {
			case 0:
				Cookie c=new Cookie("openeg",data);
				// 쿠키에 보안 설정 CODE 삽입
				c.setMaxAge(60*60*24*365);            // 쿠키 유지 기간 - 1년
				c.setPath("/"); 
				response.addCookie(c);
				buffer.append("openeg="+data +"  쿠키값 추가");
				break;
			case 1:
				Cookie[] cookies = request.getCookies();
				buffer.append("수신된 쿠키<br/>");
				for (int i = 0; i < cookies.length; i++) {
				    buffer.append(cookies[i].getName() +"=");
				    buffer.append(cookies[i].getValue() + "<br/>");
				}
				break;
			default:
				buffer.append("요청오류");
				break;
			}
			model.addAttribute("result", buffer.toString());
	        return "/test/test_secure_cookie";
		}
	

}
