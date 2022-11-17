<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- jstl 사용하기 위한 코드 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 프로젝트의 context 경로를 편하게 사용하기 위한 코드 --%>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="${root}/vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
	<link
		href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
		rel="stylesheet">

	<!-- Custom styles for this template-->
	<link href="${root}/css/sb-admin-2.min.css" rel="stylesheet">
	<link rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" />
	<title>where is my home???</title>
</head>

<body class="bg-gradient-primary">

    <div class="container">

        <main class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">회원가입</h1>
                            </div>
                            <form class="user" id="form-register" method="post" action="${root}/user/register">
                                <div class="form-group">
                                    <input type="email" class="form-control form-control-user" id="email"
                                        name="email" placeholder="이메일">
                                </div>
                                <div id="emailcheck-result" name="emailcheck-result"></div>
                                <div class="form-group row">
                                    <div class="col-sm-12 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="name"
                                            name="name" placeholder="이름">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user"
                                            id="pwd" name="password" placeholder="비밀번호">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user"
                                            id="pwdcheck" placeholder="비밀번호 확인">
                                    </div>
                                </div>
                                <a href="#" class="btn btn-primary btn-user btn-block" onclick="confirm();">
                                    회원 등록
                                </a>
                            </form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="${root}/user/forgot-password">비밀번호 재설정</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="${root}/">로그인</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        
        <script type="text/javascript">
        let isUseId = false;
        document.querySelector("#email").addEventListener("keyup", function() {
        	let email = this.value;
        	let resultDiv = document.querySelector("#emailcheck-result");
        	fetch("${root}/user/emailcheck?email=" + email)
				.then(response => response.text())
				.then(data => {
					console.log(data);
    				if(data == 0) {
    			   		resultDiv.setAttribute("class", "mb-3 text-primary");
    		       		resultDiv.textContent = email + "는 사용할 수 있습니다.";
    		       		isUseId = true;
    			 	} else {
    			   		resultDiv.setAttribute("class", "mb-3 text-danger");
      		       		resultDiv.textContent = email + "는 사용할 수 없습니다.";
      		       		isUseId = false;
    			 }
			});        	
        });
        
        function confirm() {
        	if (!document.querySelector("#email").value) {
        		alert("이메일을 입력하세요.");
        		return;
        	} else if (!document.querySelector("#name").value) {
        		alert("이름을 입력하세요.");
        		return;      		
        	} else if (!document.querySelector("#pwd").value) {
        		alert("비밀번호를 입력하세요.");
        		return;      		
            } else if (document.querySelector("#pwd").value != document.querySelector("#pwdcheck").value) {
                alert("입력된 비밀번호가 다릅니다.");
                return;
        	} else {
        		let form = document.querySelector("#form-register");
        		form.submit();
        	}
        	
        };
        
        </script>
        
<%@ include file="../include/footer.jsp"%>