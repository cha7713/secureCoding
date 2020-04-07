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
public class EsapiEncryptTestController {
	
	

	
	@RequestMapping(value="/test/esapi_encrypt_test.do", method = RequestMethod.POST)
	@ResponseBody
	public String testEncryption(HttpServletRequest request){
		StringBuffer buffer=new StringBuffer();
		String data=request.getParameter("data");
		if ( data != null ) {
	          buffer.append("ESAPI 암호화 테스트");
		}
        return buffer.toString();
		
	}
	
	@RequestMapping(value="/test/esapi_encrypt_test.do", method = RequestMethod.GET)
	public String testEncryption(HttpServletRequest request, Model model){
		StringBuffer buffer=new StringBuffer();
		String data=request.getParameter("data");
		if ( data != null ) {
	          buffer.append("ESAPI 암호화 테스트");
		}
        model.addAttribute("result", buffer.toString());
        return  "/test/esapi_encrypt_test";
		
	}
	

}
