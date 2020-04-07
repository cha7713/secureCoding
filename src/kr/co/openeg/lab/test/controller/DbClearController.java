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
public class DbClearController {
	
	static int count;
	
	@Resource(name="memberService")
	private MemberService service;
	
	@Resource(name="testService")
	private TestService testService;
	
	
	
	// DB초기화 
	@RequestMapping(value="/test/init_db.do", method = RequestMethod.GET)
	@ResponseBody
	public String initDB(HttpServletRequest request, HttpServletResponse response) throws Exception{
		StringBuffer buffer=new StringBuffer();
		String id = request.getParameter("id");
		if ( id.equals(request.getSession().getAttribute("userId")) && "admin".equals(id)) {
		     DBinit util=new DBinit();
		    // util.initMSSQLDB();
		     util.initMySQLDB();
		     buffer.append("DB 초기화 완료");
		} else {
			buffer.append("작업권한이 없습니다.");
		}
		request.getSession().invalidate();
		response.sendRedirect("/openeg/login.do");
        return buffer.toString();
		
	}
	
	
	    
	


}
