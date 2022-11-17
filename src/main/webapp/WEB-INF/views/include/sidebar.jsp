<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

   <!-- Sidebar - Brand -->
   <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index">
       <div class="sidebar-brand-icon rotate-n-15">
           <i class="fas fa-sad-tear"></i>
       </div>
       <div class="sidebar-brand-text mx-3">WHERE IS MY HOME?</div>
   </a>

   <!-- Divider -->
   <hr class="sidebar-divider my-0">

   <!-- Nav Item - Dashboard -->
   <li class="nav-item active">
       <a class="nav-link" href="${pageContext.request.contextPath}/house/searchAll">
           <i class="fas fa-fw fa-globe"></i>
           <span>전체 조회</span></a>
   </li>

   <!-- Divider -->
   <hr class="sidebar-divider">

   <!-- Heading -->
   <div class="sidebar-heading">
       게시판
   </div>

   <!-- Nav Item - Pages Collapse Menu -->
   <li class="nav-item">
       <a class="nav-link" href="#">
           <i class="fas fa-fw fa-lightbulb"></i>
           <span>공지사항</span></a>
   </li>
   <li class="nav-item">
       <a class="nav-link" href="#">
           <i class="fas fa-fw fa-newspaper"></i>
           <span>뉴 스</span></a>
   </li>
   <li class="nav-item">
       <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
           aria-expanded="true" aria-controls="collapseUtilities">
           <i class="fas fa-fw fa-align-justify"></i>
           <span>게시판</span>
       </a>
       <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
           data-parent="#accordionSidebar">
           <div class="bg-white py-2 collapse-inner rounded">
               <h6 class="collapse-header">게시판</h6>
               <a class="collapse-item" href="#">자유 게시판</a>
               <a class="collapse-item" href="#">맛집 게시판</a>
               <a class="collapse-item" href="#">정보 게시판</a>
               <a class="collapse-item" href="#">전세 사기꾼 리스트</a>
           </div>
       </div>
   </li>

   <!-- Nav Item - Utilities Collapse Menu -->
   

   <!-- Divider -->
   <hr class="sidebar-divider">

   <!-- Heading -->
   <div class="sidebar-heading">
       관심 지역
   </div>

   <!-- Nav Item - Pages Collapse Menu -->
   <li class="nav-item">
       <a class="nav-link" href="${pageContext.request.contextPath}/bookmark/searchAll">
           <i class="fas fa-fw fa-magnifying-glass-dollar"></i>
           <span>조회</span></a>
   </li>
	<hr class="sidebar-divider">

   <!-- Heading -->
   <div class="sidebar-heading">
      Q&A
   </div>

   <!-- Nav Item - Charts -->
   <li class="nav-item">
       <a class="nav-link" href="http://localhost:9000/question/list">
           <i class="fas fa-fw fa-solid fa-comments-question"></i>
           <span>Q&A</span></a>
   </li>
	<div class="sidebar-heading">
       사이트맵
   </div>
    <li class="nav-item">
       <a class="nav-link" href="${pageContext.request.contextPath}/sitemap">
           <i class="fas fa-fw fa-magnifying-glass-dollar"></i>
           <span>사이트 맵</span></a>
   </li>
   	<div class="sidebar-heading">
       웹사이트 소개
   </div>
    <li class="nav-item">
       <a class="nav-link" href="${pageContext.request.contextPath}/info">
           <i class="fas fa-fw fa-magnifying-glass-dollar"></i>
           <span>웹사이트 소개</span></a>
   </li>
   <!-- Divider -->
   <hr class="sidebar-divider d-none d-md-block">

   <!-- Sidebar Toggler (Sidebar) -->
   <div class="text-center d-none d-md-inline">
       <button class="rounded-circle border-0" id="sidebarToggle"></button>
   </div>

   <!-- Sidebar Message -->
    <div class="sidebar-card d-none d-lg-flex">
        <img class="sidebar-card-illustration mb-2" src="${pageContext.request.contextPath}/img/undraw_rocket.svg" alt="...">
        <p class="text-center mb-2"><strong>WHERE IS MY Home Pro</strong> 를 구독하여 집구하는 데 도움을 받으세요!</p>
        <a class="btn btn-success btn-sm" href="#">Upgrade to Pro!</a>
    </div>

</ul>