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

<title>인증</title>
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
	font-family: "맑은고딕", "sans-serif";
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
#comment{
	font-family: "맑은고딕", "sans-serif";
	font: bold;
	font-size: 12pt
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

						<div class="hint" id="div10">
							<p id="select-test">인증</p>
							<br>
							<br>
							<br>
							<p id="comment">시스템 보안의 첫번째는 안전하고 강력한 인증입니다. SQL인젝션이나 취약한 로직에
								의해 인증이 우회되지 않도록 구현해야 합니다.</p>
							<form action="authenticator_test.do" id="form10">
								<pre>

ID: <input type="text" name="id" id="data10-1">  PASSWORD: <input
										type="password" name="passwd" id="data10-2">  <input
										type="button" id="button10" value="실행" data-toggle="modal" data-target="#myModal">
 <br />
           </pre>
							</form>
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
		<%-- <div class="modal fade" id="myModal">
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
		$(function() {
			$('#data10-2').keydown(function(key) {
				if (key.keyCode == 13) {
					$("#button10").click();
				}

			});
			$('#button10').click( 
			 		   function() { 
			 		   	    	 var formData = $("#form10").serializeArray();  
			 			    	 var URL = $("#form10").attr("action");  
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