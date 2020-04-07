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
public class SqlController {
	
	static int count;
	
	@Resource(name="memberService")
	private MemberService service;
	
	@Resource(name="testService")
	private TestService testService;
	
	
	
	// SQL 인젝션 
	@RequestMapping(value="/test/sql_test.do", method = RequestMethod.POST)
	@ResponseBody
	public String testSqlInjection(HttpServletRequest request){
		StringBuffer buffer=new StringBuffer();
		String id=request.getParameter("id");
		String passwd=request.getParameter("passwd");
		TestUtil util=new TestUtil();
		buffer.append("ID,PASSWD 조회 결과:   " );
		buffer.append(util.readDB(id, passwd));
        return buffer.toString();
		
	}
	
	
	// SQL 인젝션 
	@RequestMapping(value="/test/sql_test_b.do", method = RequestMethod.POST)
	@ResponseBody
	public String testSqlInjectionB(HttpServletRequest request){
		StringBuffer buffer=new StringBuffer();
		String id=request.getParameter("id");
		TestUtil util=new TestUtil();
		buffer.append("MySQL 조회결과:    " );
		buffer.append(util.readDB2(id));
        return buffer.toString();
		
	}
	
	// SQL 인젝션 
		@RequestMapping(value="/test/sql_test_b.do", method = RequestMethod.GET)
		public String testSqlInjectionB(HttpServletRequest request, Model model){
			StringBuffer buffer=new StringBuffer();
			String id=request.getParameter("id");
			TestUtil util=new TestUtil();
			buffer.append("MySQL 조회결과:    " );
			buffer.append(util.readDB2(id));
			model.addAttribute("result", buffer.toString());
			return "/test/test_sql";
			
		}
	
	
	// SQL 인젝션 
	@RequestMapping(value="/test/sql_test_b2.do", method = RequestMethod.POST)
	@ResponseBody
	public String testSqlInjectionB2(HttpServletRequest request) throws Exception{
		StringBuffer buffer=new StringBuffer();
		String id=request.getParameter("id");
		TestUtil util=new TestUtil();
		buffer.append("MS SQL Server 조회결과:    " );
		buffer.append(util.readDB3(id));
        return buffer.toString();
		
	}
	// SQL 인젝션 
		@RequestMapping(value="/test/sql_test_b2.do", method = RequestMethod.GET)
		@ResponseBody
		public String testSqlInjectionB2(HttpServletRequest request, Model model) throws Exception{
			StringBuffer buffer=new StringBuffer();
			String id=request.getParameter("id");
			TestUtil util=new TestUtil();
			buffer.append("MS SQL Server 조회결과:    " );
			buffer.append(util.readDB3(id));
			model.addAttribute("result", buffer.toString());
			return "/test/test_sql";
			
		}
	
	
	

}
