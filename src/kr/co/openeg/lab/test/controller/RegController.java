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
public class RegController {
	
	static int count;
	
	@Resource(name="memberService")
	private MemberService service;
	
	@Resource(name="testService")
	private TestService testService;
	
	
	
	
	// 정규식 테스트 
	@RequestMapping(value="/test/reg_test.do",method = RequestMethod.POST)
	@ResponseBody
	public String testRegEx(HttpServletRequest request) {
		StringBuffer buffer=new StringBuffer();
		String data=request.getParameter("data");
		buffer.append("정규식테스트  입력값: "+data);
        return buffer.toString();		

	}
	
	// 정규식 테스트 
		@RequestMapping(value="/test/reg_test.do",method = RequestMethod.GET)
		public String testRegEx(HttpServletRequest request, Model model) {
			StringBuffer buffer=new StringBuffer();
			String data=request.getParameter("data");
			buffer.append("정규식테스트  입력값: "+data);
			model.addAttribute("result", buffer.toString());
			return "/test/test_reg";

		}
	

}
