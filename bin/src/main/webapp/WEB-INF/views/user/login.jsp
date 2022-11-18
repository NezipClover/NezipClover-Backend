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

 <div>
    <div class="container">

        <!-- Outer Row -->
        <main class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">로그인</h1>
                                    </div>
                                    <form id="form-login" class="user" method="post" action="${root}/user/login">
                                        <div class="form-group">
                                            <input type="email" class="form-control form-control-user"
                                                id="email" name="email" aria-describedby="emailHelp"
                                                placeholder="이메일">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                id="password" name="password" placeholder="비밀번호">
                                        </div>
                                        <!-- 
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" id="customCheck">
                                                <label class="custom-control-label" for="customCheck">아이디 저장</label>
                                            </div>
                                        </div>
                                         -->
                                        <a href="#" class="btn btn-primary btn-user btn-block" onclick="login();">
                                            로그인
                                        </a>
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="${root}/user/forgot-password">비밀번호 재설정</a>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="${root}/user/register">회원가입</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </main>
        
        <script type="text/javascript">
        function login() {
        	if (!document.querySelector("#email").value) {
        		alert("아이디를 입력하세요.");
        		return;
        	} else if (!document.querySelector("#password").value) {
        		alert("비밀번호를 입력하세요.");
        		return;      		
        	} else {
        		let form = document.querySelector("#form-login");
        		form.submit();
        	}
        	
        	
        };
    	
    	
    	<c:if test="${!empty msg}">
    		alert("${msg}");
    	</c:if>
    	
        </script>
        
<%@ include file="../include/footer.jsp"%>