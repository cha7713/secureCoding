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
public class EsapiDbController {
	
	

	
	public String readDB(String id, String passwd) {
		  StringBuffer  result=new StringBuffer();
		  Connection con=null;
		  Statement st=null;
		  ResultSet rs=null;
		  InputStream is =
		       this.getClass().getClassLoader().getResourceAsStream("config/dbconn.properties");
		  Properties props = new Properties();
		  try {
		     props.load(is);
		     String driver = props.getProperty("jdbc.driver");
		     String url = props.getProperty("jdbc.url");
		     String username = props.getProperty("jdbc.username");
		     String password = props.getProperty("jdbc.password");
		     System.out.println(driver+url+username+password);
		     Class.forName(driver);
		     con=DriverManager.getConnection(url, username, password);
		     st=con.createStatement();

		     String query =        
		             "select * from jmboard_member where userid='"+
		               id +"'"+
		              "and userpw='"+
		               passwd+"'";		
		     System.out.println(query);
		     rs=st.executeQuery(query);
		     if ( rs.next() ) {
		         result.append("ID: "+rs.getString(2));
		         result.append("    PASSWORD: "+rs.getString(3));
		     }else {
		         result.append("등록되어있지 않은 계정입니다.");
		     }
		  } catch (Exception e) {
		        e.printStackTrace();
		     System.err.println("Load failed");
		  } 
		   if ( rs != null ) try { rs.close(); }catch(SQLException e){}
		   if ( st != null ) try { st.close(); }catch(SQLException e){}
		   if ( con != null ) try { con.close(); }catch(SQLException e){}
		            
		   return result.toString();
	
	}
	

}
