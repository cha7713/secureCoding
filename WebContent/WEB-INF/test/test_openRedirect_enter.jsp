<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>오픈 리다이랙트</title>
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
							<p id="select-test">오픈 리다이랙트</p> <button class="btn btn-info test" onclick="test()">TEST</button>
							<div class="explain-container" >
									<img class="topic" alt="원인" src="../img/cause.png"> <p class="explain">사용자로부터 입력받은 값을 검증하지 않고 외부 사이트로 자동 연결(redirect)할 사이트의 주소로 사용하는 경우</p>
								<img class="topic" alt="영향" src="../img/effect.png"> <p class="explain">공격자는 외부 입력값을 조작하여 사용자를 피싱(phishing), 크로스사이트 스크립트(XSS)와 같은 공격에 노출시킬 수 있다.</p>
								<img class="topic" alt="대응" src="../img/response.png"> <p class="explain">자동 연결에 사용할 외부 사이트의 URL과 도메인을 화이트 리스트(white list)로 관리한다.<br>사용자 입력값을 자동 연결할 사이트의 주소로 사용하는 경우 화이트 리스트 내의 값인지 확인하고 사용한다.</p>
								
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
			window.location.href="/openeg/test/test_open.do?no=9-1"
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