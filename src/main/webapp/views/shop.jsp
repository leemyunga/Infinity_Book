<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<meta charset="UTF-8">
	<head>
		<title>Book Store</title>
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

		<!-- script
		================================================== -->
		<script src="/js/modernizr.js"></script>

	</head>

<body>


<div id="header-wrap">

	<div class="top-content">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="right-element">
						<a href="#" class="user-account for-buy"><i class="icon icon-user"></i><span>Account</span></a>
						<a href="#" class="cart for-buy"><i class="icon icon-clipboard"></i><span>Alarm:(0 $)</span></a>

						<div class="action-menu">
							<div class="search-bar">
								<a href="#" class="search-button search-toggle" data-selector="#header-wrap">
									<i class="icon icon-search"></i>
								</a>
								<form role="search" method="get" class="search-box">
									<input class="search-field text search-input" placeholder="Search" type="search">
								</form>
							</div>
						</div>
					</div><!--top-right-->
				</div>				
			</div>
		</div>
	</div><!--top-content-->

	<header id="header">
		<div class="container">
			<div class="row">

				<div class="col-md-2">
					<div class="main-logo">
						<a href="index.move"><img src="/images/main-logo.png" alt="logo"></a>
					</div>

				</div>

				<div class="col-md-10">
					
					<nav id="navbar">
						<div class="main-menu stellarnav">
							<ul class="menu-list">
								<li class="menu-item active"><a href="#home" data-effect="Home">Home</a></li>
								<li class="menu-item"><a href="#about" class="nav-link" data-effect="About">About</a></li>
								<li class="menu-item has-sub">
									<a href="#pages" class="nav-link" data-effect="Pages">Pages</a>

									<ul>
								        <li class="active"><a href="index.move">Home</a></li>
								        <li><a href="about.move">About</a></li>
								        <li><a href="styles.move">Styles</a></li>
								        <li><a href="blog.move">Blog</a></li>
								        <li><a href="single-post.move">Post Single</a></li>
								        <li><a href="shop.move">Our Store</a></li>
								        <li><a href="single-product.move">Product Single</a></li>
								        <li><a href="contact.move">Contact</a></li>
								        <li><a href="thank-you.move">Thank You</a></li>
								     </ul>

								</li>
								<li class="menu-item"><a href="#popular-books" class="nav-link" data-effect="Shop">Shop</a></li>
								<li class="menu-item"><a href="#latest-blog" class="nav-link" data-effect="Articles">Articles</a></li>
								<li class="menu-item"><a href="#contact" class="nav-link" data-effect="Contact">Contact Us</a></li>
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
		
</div><!--header-wrap-->

<div>
	<div class="container">
		<div class="row">
			<div class="col-md-12">			
				<div class="colored">
					<h1 class="page-title">Shop</h1>
					<div class="breadcum-items">
						<span class="item"><a href="index.move">Home /</a></span>
						<span class="item colored">Shop</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</div><!--site-banner-->

<section class="padding-large">
	<div class="container">
		<div class="row">

			<div class="products-grid grid">

			  	<figure class="product-style">
					<img src="/images/tab-item1.jpg" alt="Books" class="product-item">
					<button type="button" class="add-to-cart" data-product-tile="add-to-cart">Add to Cart</button>
					<figcaption>
						<h3>Portrait photography</h3>
						<p>Adam Silber</p>
						<div class="item-price">$ 40.00</div>
					</figcaption>
				</figure>

			  	<figure class="product-style">
					<img src="/images/tab-item2.jpg" alt="Books" class="product-item">
					<button type="button" class="add-to-cart" data-product-tile="add-to-cart">Add to Cart</button>
					<figcaption>
						<h3>Once upon a time</h3>
						<p>Klien Marry</p>
						<div class="item-price">$ 35.00</div>
					</figcaption>
				</figure>

			  	<figure class="product-style">
					<img src="/images/tab-item3.jpg" alt="Books" class="product-item">
					<button type="button" class="add-to-cart" data-product-tile="add-to-cart">Add to Cart</button>
					<figcaption>
						<h3>Tips of simple lifestyle</h3>
						<p>Bratt Smith</p>
						<div class="item-price">$ 40.00</div>
					</figcaption>
				</figure>

			  	<figure class="product-style">
					<img src="/images/tab-item4.jpg" alt="Books" class="product-item">
					<button type="button" class="add-to-cart" data-product-tile="add-to-cart">Add to Cart</button>
					<figcaption>
						<h3>Just felt from outside</h3>
						<p>Nicole Wilson</p>
						<div class="item-price">$ 40.00</div>
					</figcaption>
				</figure>

			  	<figure class="product-style">
					<img src="/images/tab-item5.jpg" alt="Books" class="product-item">
					<button type="button" class="add-to-cart" data-product-tile="add-to-cart">Add to Cart</button>
					<figcaption>
						<h3>Peaceful Enlightment</h3>
						<p>Marmik Lama</p>
						<div class="item-price">$ 40.00</div>
					</figcaption>
				</figure>

			  	<figure class="product-style">
					<img src="/images/tab-item6.jpg" alt="Books" class="product-item">
					<button type="button" class="add-to-cart" data-product-tile="add-to-cart">Add to Cart</button>
					<figcaption>
						<h3>Great travel at desert</h3>
						<p>Sanchit Howdy</p>
						<div class="item-price">$ 40.00</div>
					</figcaption>
				</figure>

			  	<figure class="product-style">
					<img src="/images/tab-item7.jpg" alt="Books" class="product-item">
					<button type="button" class="add-to-cart" data-product-tile="add-to-cart">Add to Cart</button>
					<figcaption>
						<h3>Life among the pirates</h3>
						<p>Armor Ramsey</p>
						<div class="item-price">$ 40.00</div>
					</figcaption>
				</figure>

			  	<figure class="product-style">
					<img src="/images/tab-item8.jpg" alt="Books" class="product-item">
					<button type="button" class="add-to-cart" data-product-tile="add-to-cart">Add to Cart</button>
					<figcaption>
						<h3>Simple way of piece life</h3>
						<p>Armor Ramsey</p>
						<div class="item-price">$ 40.00</div>
					</figcaption>
				</figure>

	    	</div>

		</div>
	</div>
</section>


<footer id="footer">
	<div class="container">
		<div class="row">

			<div class="col-md-4">
				
				<div class="footer-item">
					<div class="company-brand">
						<img src="/images/main-logo.png" alt="logo" class="footer-logo">
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sagittis sed ptibus liberolectus nonet psryroin. Amet sed lorem posuere sit iaculis amet, ac urna. Adipiscing fames semper erat ac in suspendisse iaculis.</p>
					</div>
				</div>
				
			</div>

			<div class="col-md-2">

				<div class="footer-menu">
					<h5>About Us</h5>
					<ul class="menu-list">
						<li class="menu-item">
							<a href="#">vision</a>
						</li>
						<li class="menu-item">
							<a href="#">articles </a>
						</li>
						<li class="menu-item">
							<a href="#">careers</a>
						</li>
						<li class="menu-item">
							<a href="#">service terms</a>
						</li>
						<li class="menu-item">
							<a href="#">donate</a>
						</li>
					</ul>
				</div>

			</div>
			<div class="col-md-2">

				<div class="footer-menu">
					<h5>Discover</h5>
					<ul class="menu-list">
						<li class="menu-item">
							<a href="#">Home</a>
						</li>
						<li class="menu-item">
							<a href="#">Books</a>
						</li>
						<li class="menu-item">
							<a href="#">Authors</a>
						</li>
						<li class="menu-item">
							<a href="#">Subjects</a>
						</li>
						<li class="menu-item">
							<a href="#">Advanced Search</a>
						</li>
					</ul>
				</div>

			</div>
			<div class="col-md-2">

				<div class="footer-menu">
					<h5>My account</h5>
					<ul class="menu-list">
						<li class="menu-item">
							<a href="#">Sign In</a>
						</li>
						<li class="menu-item">
							<a href="#">View Cart</a>
						</li>
						<li class="menu-item">
							<a href="#">My Wishtlist</a>
						</li>
						<li class="menu-item">
							<a href="#">Track My Order</a>
						</li>
					</ul>
				</div>

			</div>
			<div class="col-md-2">

				<div class="footer-menu">
					<h5>Help</h5>
					<ul class="menu-list">
						<li class="menu-item">
							<a href="#">Help center</a>
						</li>
						<li class="menu-item">
							<a href="#">Report a problem</a>
						</li>
						<li class="menu-item">
							<a href="#">Suggesting edits</a>
						</li>
						<li class="menu-item">
							<a href="#">Contact us</a>
						</li>
					</ul>
				</div>

			</div>

		</div>
		<!-- / row -->

	</div>
</footer>

<div id="footer-bottom">
	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<div class="copyright">
					<div class="row">

						<div class="col-md-12">
							<p>Â© 2022 All rights reserved. Free HTML Template by <a href="https://www.templatesjungle.com/" target="_blank">TemplatesJungle</a></p>
						</div>

						

					</div>
				</div><!--grid-->

			</div><!--footer-bottom-content-->
		</div>
	</div>
</div>

<script src="/js/jquery-1.11.0.min.js"></script>
<script src="/js/plugins.js"></script>
<script src="/js/script.js"></script>

</body>
</html>	