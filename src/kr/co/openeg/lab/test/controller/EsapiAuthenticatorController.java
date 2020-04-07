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
public class EsapiAuthenticatorController {
	
	
	@RequestMapping(value="/test/esapi_authenticator_test.do", method = RequestMethod.POST)
	@ResponseBody
	public String testAuthenticator(HttpServletRequest request, 
			HttpServletResponse response, HttpSession session){
		    StringBuffer buffer=new StringBuffer();
        	String id=request.getParameter("id");
        	String passwd=request.getParameter("passwd");
    		if ( id != null  && passwd != null ) {
  	          buffer.append("ESAPI 계정등록 테스트");
  		    }
        	
        	return buffer.toString();
        }
	
	@RequestMapping(value="/test/esapi_authenticator_test.do", method = RequestMethod.GET)
	public String testAuthenticator(HttpServletRequest request, 
			HttpServletResponse response, HttpSession session, Model model){
		    StringBuffer buffer=new StringBuffer();
        	String id=request.getParameter("id");
        	String passwd=request.getParameter("passwd");
    		if ( id != null  && passwd != null ) {
  	          buffer.append("ESAPI 계정등록 테스트");
  		    }
    		model.addAttribute("result", buffer.toString());
    		return "/test/esapi_authenticator_test";

        }
	

    
	@RequestMapping(value="/test/esapi_login_test.do", method = RequestMethod.POST)
	@ResponseBody
	public String testLogin(HttpServletRequest request, 
			HttpServletResponse response, HttpSession session){
		    StringBuffer buffer=new StringBuffer();
        	String id=request.getParameter("id");
        	String passwd=request.getParameter("passwd");
    		if ( id != null  && passwd != null ) {
    	          buffer.append("ESAPI 로그인 테스트");
    		}
        	return buffer.toString();
        }
	@RequestMapping(value="/test/esapi_login_test.do", method = RequestMethod.GET)
	public String testLogin(HttpServletRequest request, 
			HttpServletResponse response, HttpSession session,Model model){
		    StringBuffer buffer=new StringBuffer();
        	String id=request.getParameter("id");
        	String passwd=request.getParameter("passwd");
    		if ( id != null  && passwd != null ) {
    	          buffer.append("ESAPI 로그인 테스트");
    		}
    		model.addAttribute("result", buffer.toString());

    		return "/test/esapi_authenticator_test";
        }
	
	

	
	@RequestMapping(value="/test/esapi_logout_test.do", method = RequestMethod.POST)
	@ResponseBody
	public String testLogout(HttpServletRequest request){
		StringBuffer buffer=new StringBuffer();
		buffer.append("ESAPI 로그아웃 테스트");
        return buffer.toString();
		
	}
	

	

        
}
