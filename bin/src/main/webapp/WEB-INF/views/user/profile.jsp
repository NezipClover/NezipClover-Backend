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
                                        <h1 class="h4 text-gray-900 mb-4">회원정보</h1>
                                    </div>
                                    <div class="col-lg-7">
                                      <div style="padding-left: 50%;">
                                        <img src="img/icon/user.png" width="200px" alt="">
                                      </div>
                                    </div>
                                    <form class="user">
                                        <div class="form-group row">
                                            <div class="col">
                                              <label for="exampleName">이름</label>
                                                <input type="text" class="form-control form-control-user" id="name" name="name"
                                                    placeholder="${userInfo.name}" disabled="true">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                          <label for="exampleInputEmail">이메일</label>
                                            <input type="email" class="form-control form-control-user" id="email" name="email"
                                                 placeholder="${userInfo.email}" disabled="true">
                                        </div>
                                        <!-- 
                                        <div class="form-group row">
                                            <div class="col mb-3 mb-sm-0">
                                                <label for="exampleInputPassword">비밀번호</label>
                                                <input type="password" class="form-control form-control-user"
                                                    id="password" placeholder="비밀번호" disabled="true">
                                            </div>
                                        </div>
                                         -->                                        
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                      <a class="small" href="${root}/user/update_profile">회원정보 수정</a>
                                    </div>
                                    <div class="text-center">
                                      <a class="small" style="color: red;" href="${root}/user/delete">회원탈퇴</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>


                
            </div>
            <!-- End of Main Content -->

			<!-- Footer -->
			<%@ include file="../include/footer.jsp"%>