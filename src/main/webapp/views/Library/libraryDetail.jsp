<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<meta charset="UTF-8">
	<head>
		<title>Infinite B∞k</title>
		<meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <meta name="format-detection" content="telephone=no">
	    <meta name="apple-mobile-web-app-capable" content="yes">
	    <meta name="author" content="">
	    <meta name="keywords" content="">
	    <meta name="description" content="">

	    <link rel="stylesheet" type="text/css" href="/css/normalize.css">
	    <link rel="stylesheet" type="text/css" href="/icomoon/icomoon.css">
	    <link rel="stylesheet" type="text/css" href="/css/vendor.css">
	    <link rel="stylesheet" type="text/css" href="/style.css">

		<!-- script -->
		<script src="/js/modernizr.js"></script>
		<script src="/js/jquery-1.11.0.min.js"></script>
		<script src="/js/plugins.js"></script>
		<script src="/js/script.js"></script>
	</head>

<body>

<div id="header-wrap">
	<c:choose>
        <c:when test="${sessionScope.loginIdx != null}">
            <jsp:include page="../loginAfterBox.jsp" />
        </c:when>
        <c:otherwise>
            <jsp:include page="../loginBeforeBox.jsp" />            
        </c:otherwise>
    </c:choose>
    
	<header id="header">
		<div class="container">
			<div class="row">
				<div class="col-md-2">
					<div class="main-logo">
						<a href="/"><img src="/images/mainLogo.png" alt="logo"></a>
					</div>
				</div>
				<div class="col-md-10">
					<nav id="navbar">
						<div class="main-menu stellarnav">
						<br/><br/>
							<ul class="menu-list">
								<li class="menu-item active"><a href="/libraryList.get" >서재</a></li>
								<li class="menu-item"><a href="/myBookreportList.get" >감상문</a></li>
								<li class="menu-item"><a href="/trackerList.go" >트래커</a></li>
								<li class="menu-item"><a href="/calender.go" >일정</a></li>
								<li class="menu-item"><a href="/deposit" class="nav-link">보증금</a></li>
								<li class="menu-item has-sub">
									<a href="#" class="nav-link">내 정보</a>
									<ul>
								        <li class="active"><a href="#">회원 정보</a></li>
								        <li><a href="#">대여/교환 내역</a></li>
								        <li><a href="#">문의 내역</a></li>
								     </ul>
								</li>								
							</ul>
							<div class="hamburger">
				                <span class="bar"></span>
				                <span class="bar"></span>
				                <span class="bar"></span>
				            </div>
						</div>
					</nav>
				</div>
			</div>
		</div>
	</header>
</div>

<section class="hero-section jarallax">
	
	<div class="container">
		<div class="row">
			<div class="section-header align-center">
				<h2 class="section-title">Library</h2>
			</div>
		</div>
	</div>
</section>

<section id="best-selling" class="leaf-pattern-overlay">
	<div class="corner-pattern-overlay"></div>
	<div class="container">
		<table>
			<tr>
				<th rowspan="3" style="width: 40%;">
					<img src="${book.library_cover}" alt="book" class="single-image">
				</th>
				<th rowspan="3" style="width: 5%;">
					
				</th>
				<td style="width: 55%;">
					<input type="button" class="btn btn-outline-accent btn-accent-arrow" value="${book.library_use}">
					
					<table>
						<tr>
							<th colspan="3"><h3 class="item-title">${book.library_title}</h3></th>
						</tr>
						<tr>
							<td><div class="author-name">By. ${book.library_author}</div></td>
							<td><div class="author-name">${book.library_publisher}</div></td>
							<td><div class="author-name">${book.library_pubdate}</div></td>
						</tr>
						<tr>
							<td colspan="3"><h4 class="item-title">Book Info </h4><div class="author-name">${book.library_info}</div></td>
						</tr>
						<tr>
							<td colspan="3">
								<h4 class="item-title">Review</h4>
								후기 1<br/>
								후기 2<br/>
								후기 3<br/>
								후기 4<br/>
								후기 5<br/>
							</td>
						</tr>
						<tr>
							<th colspan="3" style="text-align: rigtht;">
								<input type="button" onclick="location.href='libraryList.get'" value="목록"> 
								<input type="button" onclick="location.href='libraryUpdate.go?library_idx='+${book.library_idx}" value="수정"> 
								<input type="button" onclick="location.href='library.delete?library_idx='+${book.library_idx}" value="삭제">
							</th>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	
	</div>
</section>

<div id="footer-bottom">
	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<div class="copyright">
					<div class="row">

					<div class="col-md-12" style="text-align:center;">
							<hr/>
							<p>Â© 2022 All rights reserved. Free HTML Template by <a href="https://www.templatesjungle.com/" target="_blank">TemplatesJungle</a></p>
						</div>
						

					</div>
				</div><!--grid-->

			</div><!--footer-bottom-content-->
		</div>
	</div>
</div>



</body>

</html>	