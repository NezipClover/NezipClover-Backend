<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>
</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@ include file="../include/sidebar.jsp"%>
		<!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

				<!-- Topbar -->
				<%@ include file="../include/header.jsp"%>
				<!-- End of Topbar -->
				

                <!-- Begin Page Content -->              
                <section>
                  <main class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-5 ">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">회원정보 수정</h1>
                                    </div>
                                    <form class="user" id="form-profile" method="post" action="${root}/user/modifyProfile">
                                        <div class="form-group row">
                                            <div class="col">
                                              <label for="exampleName">이름</label>
                                                <input type="text" class="form-control form-control-user" id="name" name="name"
                                                    placeholder="${userInfo.name}" value="${userInfo.name}">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                          <label for="exampleInputEmail">이메일</label>
                                            <input type="email" class="form-control form-control-user" id="email" name="email"
                                                placeholder="${userInfo.email}" value="${userInfo.email}" disabled="true">
                                        </div>
                                        <div class="form-group">
                                            <div>
                                                <label for="exampleInputPassword">비밀번호</label>
                                                <input type="password" class="form-control form-control-user"
                                                    id="pwd" name="pwd" placeholder="비밀번호">
                                            </div>
                                            <div>
                                                <label for="exampleInputPassword">비밀번호 확인</label>
                                                <input type="password" class="form-control form-control-user"
                                                    id="pwdcheck" name="pwdcheck" placeholder="비밀번호 확인">
                                            </div>
                                        </div>

                                        <a href="#" class="btn btn-primary btn-block" onclick="confirm();">수정</a>
                                        <a href="profile.jsp" class="btn btn-secondary btn-block">취소</a>
                                        <!-- <input type="submit" class="btn btn-primary btn-block" value="수정">
                                        <button class="btn btn-secondary btn-block" onclick="location.href='user/profile.jsp'">취소</button>  -->
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </section>


                
            </div>
            <!-- End of Main Content -->
            
        	<script type="text/javascript">
            function confirm() {
                
            	if (!document.querySelector("#name").value) {
            		alert("이름을 입력하세요");
            		return;
            	} else if (!document.querySelector("#pwd").value) {
                  alert("비밀번호를 입력하세요");
                  return;
                } else if (document.querySelector("#pwd").value != document.querySelector("#pwdcheck").value) {
                  alert("입력된 비밀번호가 다릅니다.");
                  return;
                } else {
                
                  let form = document.querySelector("#form-profile");
                  form.submit();
                }
              };

            </script>
            
            
			<!-- Footer -->
			<%@ include file="../include/footer.jsp"%>