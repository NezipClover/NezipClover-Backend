<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/head.jsp"%>
</head>

<body class="bg-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-password-image"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-2">비밀번호 재설정</h1>
                                        <p class="mb-4">이메일 주소를 입력하면 비밀번호 재설정 링크를 보내드립니다.</p>
                                    </div>
                                    <form class="user">
                                        <div class="form-group">
                                            <input type="email" class="form-control form-control-user"
                                                id="exampleInputEmail" aria-describedby="emailHelp"
                                                placeholder="이메일 입력">
                                        </div>
                                        <a href="${root}/user/login.jsp" class="btn btn-primary btn-user btn-block">
                                            비밀번호 재설정
                                        </a>
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="${root}/user/register.jsp">회원가입</a>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="${root}/user/login.jsp">로그인</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>
        
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
        
        </script>
        
<%@ include file="../include/footer.jsp"%>