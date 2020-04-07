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
public class EspiRedirectController {


	
	
	@RequestMapping(value="/test/esapi_redirect_test.do", method = RequestMethod.POST)
	@ResponseBody
	public String testForwarding(HttpServletRequest request,HttpServletResponse response){
		StringBuffer buffer=new StringBuffer();
		String url=request.getParameter("data");
		if ( url != null) {
	          buffer.append("ESAPI 리다이렉트 테스트");
		}
		return buffer.toString();
	}

}
