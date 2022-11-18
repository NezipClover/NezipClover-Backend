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
                                        <h1 class="h4 text-gray-900 mb-4">회원탈퇴</h1>
                                    </div>
                                    <div class="col-lg-7">
                                      <div style="padding-left: 50%;">
                                        <img src="img/icon/user.png" width="200px" alt="">
                                      </div>
                                    </div>
                                    <form class="user" id="form-delete" method="post" action="${root}/delete.user">

                                        <div class="form-group row">
                                            <div class="col mb-3 mb-sm-0">
                                                <label for="exampleInputPassword">비밀번호</label>
                                                <input type="password" class="form-control form-control-user"
                                                    id="pwd" name="pwd" placeholder="비밀번호">
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                          <div class="col mb-3 mb-sm-0">
                                              <label for="exampleInputPassword">비밀번호 확인</label>
                                              <input type="password" class="form-control form-control-user"
                                                  id="pwdcheck" name="pwdcheck" placeholder="비밀번호">
                                          </div>
                                      </div>
                                      <a class="btn-lg btn-danger" href="#" onclick="confirm();">회원탈퇴</a>
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
            	if (!document.querySelector("#pwd").value) {
                  alert("비밀번호를 입력하세요");
                  return;
                } else if (document.querySelector("#pwd").value != document.querySelector("#pwdcheck").value) {
                  alert("입력된 비밀번호가 다릅니다.");
                  return;
                } else {
                  let form = document.querySelector("#form-delete");
                  form.submit();
                }
              };

            </script>
            

			<!-- Footer -->
			<%@ include file="../include/footer.jsp"%>