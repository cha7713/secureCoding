package kr.co.openeg.lab.test.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ESAPITestController {
	
	@RequestMapping("/test/esapi_test.do")
	public String test() {		
		
		return "/test/esapi_test";
	}
	
		
	@RequestMapping(value="/test/esapi_test_open.do", method = RequestMethod.GET)
	public String esapiTestOpen(HttpServletRequest request, Model model){
		int no = Integer.parseInt(request.getParameter("no"));
		
		switch (no) {
		case 1:
			return "/test/esapi_encode_test";
		case 2:
			return "/test/esapi_encrypt_test";
		case 3:
			return "/test/esapi_sql_test";
		case 4:
			return "/test/esapi_xss_test";
		case 5:
			return "/test/esapi_authenticator_test";
		case 6:
			return "/test/esapi_validation_test";
		case 7:
			return "/test/esapi_redirect_test";
		default:
			return "/test/esapi_encode_test";
		}
		
	}
	

	

	
	
	

}
