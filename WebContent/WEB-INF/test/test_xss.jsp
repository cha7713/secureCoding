<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>XSS</title>
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

#box3 {
	float: left;
	width: 98%;
	padding: 10px;
	display: block;
	margin-bottom: 10px;
	height: 100px;
	bottom: 0px;
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
	padding-left: 10px;
	height: 350px;

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
	margin: 0;
	display: inline-block;
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
.comment{
	font-family: "맑은고딕", "sans-serif";
	font: bold;
	font-size: 15pt
}

</style>
<link href="../css/modal.css" rel="stylesheet" type="text/css" />
<link href="../css/main.css" rel="stylesheet" type="text/css" />
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

						<div class="hint" id="div6">
							<p id="select-test">XSS</p>
							<a href="#" type="button"  id="step-change" onclick="stepChange()">next step-></a>
								<br>
								<br>
								<br>
							<p id="comment">외부입력값에 스크립트요소가 포함되어 있는 경우 이값을 적절하게 필터링하지 않고
								사용자에게 응답하도록 서버 프로그램이 작성되어 있으면 해당 서버를 통해 공격자는 악성코드를 배포하게 되고 서버에
								접속한 사용자들은 악성 스크립트를 다운로드 받아 실행하는 침해사고가 발생할 수 있습니다.</p>
							<div id="step" >
							<form action="xss_test.do" id="form3">	<pre>(1) Reflective XSS  <br /><input type="text" name="data" id="data3" size="50"><input	 type="button" id="button3" value="실행" data-toggle="modal" data-target="#myModal"></pre></form>
					<!-- <form action="xss_test_b.do" id="form20"><pre>(2) Stored XSS<br /><input type="text" name="data" id="data20" size="50"><input type="button" id="button20" value="실행" > 입력값: 1 or 2</pre></form>
							<form action="xss_test_c.do" id="form21"><pre>(3) DOM XSS  <br /><input type="text" name="data" id="data21" size="50"> <input	type="submit" value="실행" data-toggle="modal" data-target="#myModal"><br /></pre></form> -->
							</div>
						</div>
<div id="box3">
						<p>실행결과</p>
						<div id="result">						
							${result}
						</div>
						</div>
					</div>
					
				</div>

				<div id="footer">
					<jsp:include page="../board/footer.jsp" />
				</div>

			</div>
		</div>
	<%-- 	<div class="modal fade" id="myModal">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h2 class="modal-title">실행결과</h2>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<br/>
					<br/>
					<div id="result" class="modal-body"><b>${result}</b></div>
					<br/>
					<br/>
					<div class="modal-body clarification" ><b></b></div>

					<!-- Modal footer -->
					<div class="modal-footer">
					
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
					</div>

				</div>
			</div>
		</div> --%>
	</div>

	<script type="text/javascript">
	
	const stepChange=()=>{
		
		let id = $('#step>form').attr('id');
		$('#step').empty();
		$('#result').empty();

		if (id == 'form3') {
			$('#step').html('<form action="xss_test_b.do" id="form20"><pre>(2) Stored XSS<br /><input type="text" name="data" id="data20" size="50"><input type="button" id="button20" value="실행" class="btnn"> 입력값: 1 or 2</pre></form>')
		}else if(id == 'form20'){
		 	$('#step').html('<form action="xss_test_c.do" id="form21"><pre>(3) DOM XSS  <br /><input type="text" name="data" id="data21" size="50"> <input	type="submit" value="실행" class="btnn" data-toggle="modal" data-target="#myModal"><br /></pre></form>') 
		}else if(id == 'form21'){
			 $('#step').html('<form action="xss_test.do" id="form3">	<pre>(1) Reflective XSS  <br /><input type="text" name="data" id="data3" size="50"><input	 type="button" id="button3" value="실행" class="btnn" data-toggle="modal" data-target="#myModal"></pre></form>') 				
		}

	}
		$(function() {
			$('#document').keydown(function(key) {
				if (key.keyCode == 13) {
					$(".btnn").click();
				}

			});
		
			
			$(document).on( "click" , ".btnn", 
		    	     function() { 
		    	    	 var formData = $("form").serializeArray();  
			    	     var URL = $("form").attr("action");  
			    	     $('#result').empty(); 
			    	     $.post(URL,  
		 	    			   formData,   
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