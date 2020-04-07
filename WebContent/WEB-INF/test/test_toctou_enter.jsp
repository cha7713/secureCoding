<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>toctou</title>
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
							<p id="select-test">TOCTOU<span style="font-size: 10pt; color: navy;">(검사시점과 사용시점)</span></p> <button class="btn btn-info test" onclick="test()">TEST</button>
							<div class="explain-container" >
								<img class="topic" alt="원인" src="../img/cause.png"> <p class="explain">병렬 실행 환경의 응용 프로그램에서 자원을 검사하는 시점과 자원을 사용하는 시점의 상태가 달라 오동작을 일으키는 경우</p>
								<img class="topic" alt="영향" src="../img/effect.png"> <p class="explain">프로그램이 교착 상태에 빠지거나 경쟁(공유) 자원의 변조나 삭제 및 기타 동기화 오류 등이 발생할 수 있다.	</p>
								<img class="topic" alt="대응" src="../img/response.png"> <p class="explain">경쟁(공유) 자원(예: 파일)을 여러 스레드가 접근하여 사용할 경우, 동기화 구문(synchronized)을 이용하여 한번에 하나의 스레드만 접근할 수 있도록 프로그램을 작성한다.<br>
																										동기화 구문은 성능에 미치는 영향을 최소화하기 위해 임계코드 주변에만 적용한다.</p>
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
			window.location.href="/openeg/test/test_open.do?no=16-1"
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