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
public class TestController {
	
	static int count;
	
	@Resource(name="memberService")
	private MemberService service;
	
	@Resource(name="testService")
	private TestService testService;
	
	@RequestMapping("/test/test.do")
	public String test() {		
		
		return "/test/test";
	}
	
	@RequestMapping(value="/test/test_open.do", method = RequestMethod.GET)
	public String esapiTestOpen(HttpServletRequest request, Model model){
		String no = request.getParameter("no");
		
		switch (no) {
		case "1":
			return "/test/test_encode";
		case "2":
			return "/test/test_reg";
		case "3":
			return "/test/test_sql_enter";
		case "3-1":
			return "/test/test_sql";
		case "4":
			return "/test/test_command_enter";
		case "4-1":
			return "/test/test_command";
		case "5":
			return "/test/test_xPath_enter";
		case "5-1":
			return "/test/test_xPath";
		case "6":
			return "/test/test_xss_enter";
		case "6-1":
			return "/test/test_xss";
		case "7":
			return "/test/test_csrf_enter";
		case "7-1":
			return "/test/test_csrf";
		case "8":
			return "/test/test_encrypt_enter";
		case "8-1":
			return "/test/test_encrypt";
		case "9":
			return "/test/test_openRedirect_enter";
		case "9-1":
			return "/test/test_openRedirect";
		case "10":
			return "/test/test_secure_cookie_enter";
		case "10-1":
			return "/test/test_secure_cookie";
		case "11":
			return "/test/test_authenticator_enter";
		case "11-1":
			return "/test/test_authenticator";
		case "12":
			return "/test/test_http_split_enter";
		case "12-1":
			return "/test/test_http_split";
		case "13":
			return "/test/test_access_control_enter";
		case "13-1":
			return "/test/test_access_control";
		case "14":
			return "/test/test_exception_enter";
		case "14-1":
			return "/test/test_exception";
		case "15":
			return "/test/test_int_overflow_enter";
		case "15-1":
			return "/test/test_int_overflow";
		case "16":
			return "/test/test_toctou_enter";
		case "16-1":
			return "/test/test_toctou";	
		case "17":
			return "/test/test_session_data_enter";
		case "17-1":
			return "/test/test_session_data";
		case "18":
			return "/test/test_loop_enter";
		case "18-1":
			return "/test/test_loop";
		case "19":
			return "/test/test_null_enter";
		case "19-1":
			return "/test/test_null";
		case "20":
			return "/test/test_encap_enter";
		case "20-1":
			return "/test/test_encap";
		case "21":
			return "/test/test_info_enter";
		case "21-1":
			return "/test/test_info";
		default:
			return "/test/test_encode";
		}
		
	}	
	
	
	
	    
	


}
