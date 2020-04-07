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
public class ToctouController {
	
	static int count;
	
	@Resource(name="memberService")
	private MemberService service;
	
	@Resource(name="testService")
	private TestService testService;

	
	
	
	// TOCTOU
	@RequestMapping(value="/test/concurrency_test.do", method = RequestMethod.POST)
	@ResponseBody
	public String testConcurrency(HttpServletRequest request){
		    StringBuffer buffer=new StringBuffer();			
		    buffer.append("실행결과1: "+ count +"<br/>");
		    count=count+TestUtil.getInt(request.getParameter("data"));
		    try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				buffer.append("처리 불가");
			}
		    buffer.append("실행결과2: "+count);
		
        return buffer.toString();	
	}
	@RequestMapping(value="/test/concurrency_test.do", method = RequestMethod.GET)
	public String testConcurrency(HttpServletRequest request, Model model){
		    StringBuffer buffer=new StringBuffer();			
		    buffer.append("실행결과1: "+ count +"<br/>");
		    count=count+TestUtil.getInt(request.getParameter("data"));
		    try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				buffer.append("처리 불가");
			}
		    buffer.append("실행결과2: "+count);
		    model.addAttribute("result", buffer.toString());
		
        return "test/test_toctou";	
	}
	
	

}
