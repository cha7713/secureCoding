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
public class SessionDataController {
	
	static int count;
	
	@Resource(name="memberService")
	private MemberService service;
	
	@Resource(name="testService")
	private TestService testService;
	
	
	
	
	
	// 세션정보 노출 
	@RequestMapping(value="/test/session_data_test.do")
	@ResponseBody
	public String testSessionData(HttpServletRequest request, HttpSession session){
		StringBuffer buffer=new StringBuffer();	
		CustomerService cust=CustomerService.getInstance();	
		Customer c=new Customer(request.getParameter("name"),
	                                                  request.getParameter("phone"));
		
		//session.setAttribute("customer", cust.getCustomer());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			buffer.append("요청 작업을 처리할 수 없습니다: 10001");
		}
		//Customer c=(Customer)session.getAttribute("customer");
		synchronized (this) {
			cust.setCustomer(c);
			buffer.append(cust.displayCustomer());
		}
        return buffer.toString();	
	}	
	

}
