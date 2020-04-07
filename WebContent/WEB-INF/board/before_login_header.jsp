<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.log_info {
	float: right;
	color: white;
	size: 8px;
	margin: 0px;
	padding: 0px;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: rgb(64, 175, 183);
	color: white;;
}

li {
	float: left;
}

li a, .dropbtn {
	display: inline-block;
	text-align: center;
	padding: 12px 10px;
	text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
	background-color: #deb887;
}

li.dropdown {
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #deb887;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: rgb(64, 175, 183);
}

.dropdown:hover .dropdown-content {
	display: block;
	color: black;;
}

#nav {
	float: left;
	width: 100%;
	background: rgb(64, 175, 183);
}

#nav > ul {
	margin: 0;
	padding: 0;
}

#nav > ul > li > a {
	color: white;
}

#nav ul  li  a {
	color: white;
}

.sub-ul{
width: 200px;
background-color: #deb887;

}
.sub-ul li{
width: 100%;
}

.sub-ul li a{
width: 80%;
}

div.depth2{
	visibility: hidden;
}

</style>
	
<script>
    function confirmInitDB() {
    	if ( confirm("정말 초기화 하시겠습니까?")  ) {
    		return true;
    	} else {
    		return false;
    	}
    }
</script>
</head>

<body>
    <div id="header">
         <img id="header-img" src="img/nav.png" width="100%"   height="80px" align="bottom" />
    </div>
	<div id="nav">
		<ul>
			<li><a href="<%=request.getContextPath()%>/board/main.do">홈으로</a></li>
			<li><a href="<%=request.getContextPath()%>/board/list.do">게시판</a></li>
			<li><a href="<%=request.getContextPath()%>/test/test.do?no=0">보안코딩테스트</a></li>
			<li><a href="<%=request.getContextPath()%>/test/esapi_test.do?no=0">ESAPI 테스트</a></li>
  		   <li><a href="http://openeg.co.kr" target="_blank">OPENEG</a></li> 
<!-- 			<li><a href="http://cafe.naver.com/sunschool" target="_blank">SunSchool</a></li> -->
			<li><a href="<%=request.getContextPath()%>/test/init_db.do?id=${userId}"  onclick="return confirmInitDB();">DB초기화</a></li>
		</ul>
	</div>
</body>
</html>