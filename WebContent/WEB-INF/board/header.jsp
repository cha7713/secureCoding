<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
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
width: 83%;
}

div.depth2{
	visibility: hidden;
}



</style>

<script>
	function confirmInitDB() {
		if (confirm("정말 초기화 하시겠습니까?")) {
			return true;
		} else {
			return false;
		}
	}
	

	
	
</script>
</head>

<body>
	<div id="header">
		<img  id="header-img" src="../img/nav.png" width="100%" height="80px"
			align="bottom" />
	</div>
	<div id="nav" style="float: left; width: 100%; background: #999;">
		<ul>
			<li><a href="<%=request.getContextPath()%>/board/main.do">홈으로</a></li>
			<li><a href="<%=request.getContextPath()%>/board/list.do">게시판</a></li>
			<li class="dropdown"><a href="#" class="dropbtn depth1">시큐어코딩테스트</a>
				<%-- <div class="dropdown-content">
					<a href="<%=request.getContextPath()%>/test/test_open.do?no=1">인코딩</a> <!-- 입력데이터 검증 및 표현 -->
					<a href="<%=request.getContextPath()%>/test/test_open.do?no=2">정규식</a> <!-- 입력데이터 검증 및 표현 -->
					<a href="<%=request.getContextPath()%>/test/test_open.do?no=3">SQL	인젝션</a> <!-- 입력데이터 검증 및 표현 -->
					<a href="<%=request.getContextPath()%>/test/test_open.do?no=4">명령어인젝션</a> <!-- 입력데이터 검증 및 표현 -->
					<a href="<%=request.getContextPath()%>/test/test_open.do?no=5">XPath인젝션</a> <!-- 입력데이터 검증 및 표현 -->
					<a href="<%=request.getContextPath()%>/test/test_open.do?no=6">XSS</a> <!-- 입력데이터 검증 및 표현 -->
					<a href="<%=request.getContextPath()%>/test/test_open.do?no=7">CSRF</a> <!-- 입력데이터 검증 및 표현 -->
					<a href="<%=request.getContextPath()%>/test/test_open.do?no=8">암호화</a> <!-- 보안기능 -->
					<a href="<%=request.getContextPath()%>/test/test_open.do?no=9">오픈리다이렉트</a> <!-- 보안기능 -->
					<a href="<%=request.getContextPath()%>/test/test_open.do?no=10">보안쿠키</a> <!-- 보안기능 -->
					<a href="<%=request.getContextPath()%>/test/test_open.do?no=11">인증</a> <!-- 보안기능 -->
					<a href="<%=request.getContextPath()%>/test/test_open.do?no=12">HTTP응답분할</a> <!-- 입력데이터 검증 및 표현 -->
					<a href="<%=request.getContextPath()%>/test/test_open.do?no=13">접근제어</a> <!-- 보안기능 -->
					<a href="<%=request.getContextPath()%>/test/test_open.do?no=14">예외처리</a> <!-- 에러처리 -->
					<a href="<%=request.getContextPath()%>/test/test_open.do?no=15">정수오버플로우</a> <!-- 입력데이터 검증 및 표현 -->
					<a href="<%=request.getContextPath()%>/test/test_open.do?no=16">TOCTOU</a> <!-- 시간 및 상태 -->
					<a href="<%=request.getContextPath()%>/test/test_open.do?no=17">세션간의 정보노출</a> <!-- 캡슐화 -->
					<a href="<%=request.getContextPath()%>/test/test_open.do?no=18">반복문제어	부재</a> <!-- 시간 및 상태 -->
					<a href="<%=request.getContextPath()%>/test/test_open.do?no=19">널포인트 역참조</a> <!-- 코드오류 -->
					<a href="<%=request.getContextPath()%>/test/test_open.do?no=20">캡슐화 위배</a> <!-- 캡슐화 -->
					<a href="<%=request.getContextPath()%>/test/test_open.do?no=21">중요정보 노출</a> <!-- 보안기능 -->
				</div> --%>
					<div class="dropdown-content">
						<ul class="sub-ul">
							<li class="dropdown"  ><a id="dropbtn1" href="#" class="dropbtn depth2"  >입력데이터 검증 및 표현</a>
								<div class="dropdown-content depth2"  id="depth1-2"  >
									<a href="<%=request.getContextPath()%>/test/test_open.do?no=1">인코딩</a>
									<a href="<%=request.getContextPath()%>/test/test_open.do?no=2">정규식</a>
									<a href="<%=request.getContextPath()%>/test/test_open.do?no=3">SQL 인젝션</a>
									<a href="<%=request.getContextPath()%>/test/test_open.do?no=4">명령어 인젝션</a>
									<a href="<%=request.getContextPath()%>/test/test_open.do?no=5">XPath 인젝션</a>
									<a href="<%=request.getContextPath()%>/test/test_open.do?no=6">XSS</a>
									<a href="<%=request.getContextPath()%>/test/test_open.do?no=7">CSRF</a>
									<a href="<%=request.getContextPath()%>/test/test_open.do?no=9">오픈 리다이랙트</a>
									<a href="<%=request.getContextPath()%>/test/test_open.do?no=12">HTTP 응답분할</a>
									<a href="<%=request.getContextPath()%>/test/test_open.do?no=15">정수 오버플로우</a>
								</div>
							</li>
							</ul>
							<ul class="sub-ul">
							<li class="dropdown" ><a id="dropbtn2" href="#" class="dropbtn depth2" >보안기능</a>
								<div class="dropdown-content depth2"  id="depth2-2">
									<a href="<%=request.getContextPath()%>/test/test_open.do?no=8">암호화</a>
									<a href="<%=request.getContextPath()%>/test/test_open.do?no=10">보안쿠키</a>
									<a href="<%=request.getContextPath()%>/test/test_open.do?no=11">인증</a>
									<a href="<%=request.getContextPath()%>/test/test_open.do?no=13">접근제어</a>
									<a href="<%=request.getContextPath()%>/test/test_open.do?no=21">중요정보 노출</a>									
								</div>
							</li>
							</ul>
							<ul class="sub-ul">
							<li class="dropdown" ><a id="dropbtn3" href="#" class="dropbtn depth2" >시간 및 상태</a>
								<div class="dropdown-content depth2"  id="depth3-2">
									<a href="<%=request.getContextPath()%>/test/test_open.do?no=16">TOCTOU</a>
									<a href="<%=request.getContextPath()%>/test/test_open.do?no=18">반복문제어	부재</a>
									
								</div>
							</li>
							</ul>
							<ul class="sub-ul">
							<li class="dropdown" ><a id="dropbtn4" href="#" class="dropbtn depth2" >에러처리</a>
								<div class="dropdown-content depth2" id="depth4-2" >
									<a href="<%=request.getContextPath()%>/test/test_open.do?no=14">예외처리</a>
									
								</div>
							</li>
							</ul>
							<ul class="sub-ul">
							<li class="dropdown" ><a id="dropbtn5" href="#" class="dropbtn depth2" >코드오류</a>
								<div class="dropdown-content depth2" id="depth5-2">
									<a href="<%=request.getContextPath()%>/test/test_open.do?no=19">널포인트 역참조</a>
									
								</div>
							</li>
							</ul>
							<ul class="sub-ul">
							<li class="dropdown" ><a id="dropbtn6" href="#" class="dropbtn depth2" >캡슐화</a>
								<div class="dropdown-content depth2" id="depth6-2">
									<a href="<%=request.getContextPath()%>/test/test_open.do?no=17">세션간 정보 노출</a>
									<a href="<%=request.getContextPath()%>/test/test_open.do?no=20">캡슐화 위배</a>
									
									
								</div>
							</li>
							</ul>
							<ul class="sub-ul">
							<li class="dropdown" ><a id="dropbtn7" href="#" class="dropbtn depth2" >API 오용</a>
								<div class="dropdown-content depth2"  id="depth7-2">
									
								</div>
							</li>
						</ul>										
					</div>
				</li>
			<li class="dropdown"><a href="#" class="dropbtn">ESAPI 테스트</a>
				<div class="dropdown-content">
					<a href="<%=request.getContextPath()%>/test/esapi_test_open.do?no=1">인코딩</a>
					<a href="<%=request.getContextPath()%>/test/esapi_test_open.do?no=2">암호화</a>
					<a href="<%=request.getContextPath()%>/test/esapi_test_open.do?no=3">SQL인젝션</a> 
					<a href="<%=request.getContextPath()%>/test/esapi_test_open.do?no=4">XSS</a>
					<a href="<%=request.getContextPath()%>/test/esapi_test_open.do?no=5">회원관리</a>
					<a href="<%=request.getContextPath()%>/test/esapi_test_open.do?no=6">Vaadation</a>
					<a href="<%=request.getContextPath()%>/test/esapi_test_open.do?no=7">Redirect</a>
				</div></li>
			<li><a href="http://openeg.co.kr" target="_blank">OPENEG</a></li>
			<!-- 			<li><a href="http://cafe.naver.com/openeg" target="_blank">커뮤니티</a></li> -->
			<li><a
				href="<%=request.getContextPath()%>/test/init_db.do?id=${userId}"
				onclick="return confirmInitDB();">DB초기화</a></li>
			<c:if test="${userId != null }">
				<li style="float: right;" class="log_info">[ ${userId } ]님 <a
					href="<%=request.getContextPath()%>/logout.do">로그아웃</a>
				</li>
			</c:if>
		</ul>

	</div>
	<script type="text/javascript">
	$(
		 function () {
			
			 $(".depth1").hover(()=>{
				$("#depth1-2").css('visibility','hidden'); 
				$("#depth2-2").css('visibility','hidden'); 
				$("#depth3-2").css('visibility','hidden'); 
				$("#depth4-2").css('visibility','hidden'); 
				$("#depth5-2").css('visibility','hidden'); 
				$("#depth6-2").css('visibility','hidden'); 
				$("#depth7-2").css('visibility','hidden'); 	
			}); 
			
			
			
			 
			 $("#dropbtn1").hover(()=>{
				 $("#depth2-2").hide();
				 $("#depth3-2").hide();
				 $("#depth4-2").hide();
				 $("#depth5-2").hide();
				 $("#depth6-2").hide();
				 $("#depth7-2").hide(); 
				 $("#depth1-2").css('visibility', 'visible');
				 $("#dropbtn1").css("display","inline-block");
				 $("#depth1-2").css("display", "inline");
				 
				 
				 
			 })
			 
			 $("#dropbtn2").hover(()=>{
				 $("#depth1-2").hide();
				 $("#depth2-2").css('visibility', 'visible');
				 $("#depth3-2").hide();
				 $("#depth4-2").hide();
				 $("#depth5-2").hide();
				 $("#depth6-2").hide();
				 $("#depth7-2").hide();
				 $("#dropbtn2").css("display","inline-block");
				 $("#depth2-2").css("display", "inline");
				 
			 })
			 $("#dropbtn3").hover(()=>{
				 $("#depth1-2").hide();
				 $("#depth2-2").hide();
				 $("#depth3-2").css('visibility', 'visible');
				 $("#depth4-2").hide();
				 $("#depth5-2").hide();
				 $("#depth6-2").hide();
				 $("#depth7-2").hide();
				 $("#dropbtn3").css("display","inline-block");
				 $("#depth3-2").css("display", "inline");
				 
			 })
			 $("#dropbtn4").hover(()=>{
				 $("#depth1-2").hide();
				 $("#depth2-2").hide();
				 $("#depth3-2").hide();
				 $("#depth4-2").css('visibility', 'visible');
				 $("#depth5-2").hide();
				 $("#depth6-2").hide();
				 $("#depth7-2").hide();
				 $("#dropbtn4").css("display","inline-block");
				 $("#depth4-2").css("display", "inline");
				 
			 })
			 
			 $("#dropbtn5").hover(()=>{
				 $("#depth1-2").hide();
				 $("#depth2-2").hide();
				 $("#depth3-2").hide();
				 $("#depth4-2").hide();
				 $("#depth5-2").css('visibility', 'visible');
				 $("#depth6-2").hide();
				 $("#depth7-2").hide();
				 $("#dropbtn5").css("display","inline-block");
				 $("#depth5-2").css("display", "inline");
				 
			 })
			 
			 $("#dropbtn6").hover(()=>{
				 $("#depth1-2").hide();
				 $("#depth2-2").hide();
				 $("#depth3-2").hide();
				 $("#depth4-2").hide();
				 $("#depth5-2").hide();
				 $("#depth6-2").css('visibility', 'visible');
				 $("#depth7-2").hide();
				 $("#dropbtn6").css("display","inline-block");
				 $("#depth6-2").css("display", "inline");
				 
			 })
			 $("#dropbtn7").hover(()=>{
				 $("#depth1-2").hide();
				 $("#depth2-2").hide();
				 $("#depth3-2").hide();
				 $("#depth4-2").hide();
				 $("#depth5-2").hide();
				 $("#depth6-2").hide();
				 $("#depth7-2").css('visibility', 'visible');
				 $("#dropbtn7").css("display","inline-block");
				 $("#depth7-2").css("display", "inline");
				 
			 })
	
		 
		})
		
		
	
	
	
	</script>
</body>
</html>