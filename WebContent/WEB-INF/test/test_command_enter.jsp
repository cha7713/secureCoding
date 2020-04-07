<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>명령어 인젝션</title>
<style type="text/css">
#box2 {
	float: left;
	width: 98%;
	padding: 10px;
	display: inline;
	margin-bottom: 10px;
	height: 500px;
	background-image: url("../img/card.png");
	background-repeat: no-repeat ;
	background-position: -25px 0px;
}

.comment {
	font-size: 12px;
	color: #555;
	margin: 1px;
	padding: 1px;
	font-weight: normal;
}

.result {
	font-size: 16px;
	color: red;
	font-weight: bold;
	margin-top: 10px;
	margin-bottom: 10px;
}

.hint {
	font-size: 22px;
	font-weight: bold;
}

#comment {
	color: #666;
	font-family: "맑은고딕", "sans-serif";
	font-size: 11pt;
}

#side-title {
	background-color: #eee;
	font-weight: bold;
	width: 200px;
	height: 30px;
	font-family: "맑은고딕", "sans-serif";
	color: #444;
	font-size: 16px;
	text-align: center;
	padding-top: 10px;
	margin: 0;
}

#select-test {
	width: 250px;
	height: 30px;
	font-weight: bold;
	font-family: "맑은고딕", "sans-serif";
	color: navy;
	font-size: 16pt;
	text-align: left;
	padding-top: 10px;
	padding-bottom: 30px;
	padding-left: 10px;
	margin: 0;
	display: inline-block;
}
#subject1{
	background-color: navy;
	width: 100px;
	height: 30px;
	font-weight: bold;
	font-family: "맑은고딕", "sans-serif";
	color: #ffffff;
	font-size: 16pt;
	text-align: center;
	padding-top: 10px;
	margin: 0;
}

#subject2{
	background-color: maroon;
	width: 100px;
	height: 30px;
	font-weight: bold;
	font-family: "맑은고딕", "sans-serif";
	color: #ffffff;
	font-size: 16pt;
	text-align: center;
	padding-top: 10px;
	margin: 0;
}
#subject3{
	background-color: purple;
	width: 100px;
	height: 30px;
	font-weight: bold;
	font-family: "맑은고딕", "sans-serif";
	color: #ffffff;
	font-size: 16pt;
	text-align: center;
	padding-top: 10px;
	margin: 0;
}
.explain{
	font-size: 12pt;
	padding-left: 40px;
	margin-top: 0px;
	padding-bottom: 30px;
}

#test-result {
	background-color: #bc8f8f;
	width: 200px;
	height: 30px;
	font-weight: bold;
	font-family: "맑은고딕", "sans-serif";
	color: #ffffff;
	font-size: 16pt;
	text-align: center;
	padding-top: 10px;
	margin: 0;
}

.test{

	float: right;
	height: 33px;
}
.topic{
height: 30px;
}

.explain-container{
padding-top: 50px;
}
</style>
<link href="../css/main.css" rel="stylesheet" type="text/css" />
<link href="../css/modal.css" rel="stylesheet" type="text/css" />
<script src="../js/webtoolkit.base64.js"></script>
<script src="../js/jquery-1.7.1.js"></script>

</head>
<body>
	<div id="container">

		<h1>
			<jsp:include page="../board/header.jsp" />
		</h1>


		<div id="content-container">
			<div id="content" style="width: 100%;">

				<div id="box2">

					<div id="labs">

						<div class="hint" id="div16">
							<p id="select-test">Command 인젝션</p> <button class="btn btn-info test" onclick="test()">TEST</button>
							<div class="explain-container" >
								<img class="topic" alt="원인" src="../img/cause.png"> <p class="explain">외부 입력값을 검증, 제한하지 않고 운영체제 명령문 생성 및 실행에 사용하는 경우</p>
								<img class="topic" alt="영향" src="../img/effect.png"> <p class="explain">공격자가 삽입한 운영체제 명령어가 웹 애플리케이션 서버의 실행 권한으로 실행되어 시스템 내부의 중요 파일이 삭제되거나 백도어가 실행되는 심각한 문제가 발생한다.</p>
								<img class="topic" alt="대응" src="../img/response.png"> <p class="explain">애플리케이션 내부에서 운영체제 명령어가 실행되지 않도록 프로그램을 설계한다.<br>외부에서 전달되는 값을 내부 명령에 직접적으로 사용하지 않고, 프로그램 내부에 미리 정의되어 있는 허용 목록을 검색하여 사용하도록 프로그램을 설계한다.</p>
																
							</div>


						</div>

					</div>

				</div>

				<div id="footer">
					<jsp:include page="../board/footer.jsp" />
				</div>

			</div>
		</div>
	</div>

	<script type="text/javascript">
		function test() {
			window.location.href="/openeg/test/test_open.do?no=4-1"
		}
	
		$(function() {
			$('#button16').click( 
			  		   function() { 
			  		   	    	 var formData = $("#form16").serializeArray();  
			  			    	 var URL = $("#form16").attr("action");  
			  			    	 $('#result').empty(); 
			  			    	 $.post(URL,formData,   
			  			    			function(data, textStatus, jqXHR)     {        	    		             
			  		   	    		           $('#result').append(data); 
			  		   	    		    } 
			  		    	    	   ).fail(function(jqXHR, textStatus, errorThrown) {   
			  		   	    		    	   $('#result').append("요청처리 실패"); 
			  		   	    	         }); 
			  		   });

		});
	</script>
	<!--  	var uri = "http://w3schools.com/my test.asp?name=st책le&car=saab"; -->
	<!--  	var uri_enc = encodeURIComponent(uri); -->
	<!--  	var uri_dec = decodeURIComponent(uri_enc); -->
	<!--  	var res = uri_enc + "<br>" + uri_dec; -->



</body>
</html>