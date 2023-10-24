<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Store List</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

<!-- 내가 만든 스타일시트 -->
<link rel="stylesheet" type="text/css" href="/css/store/style.css">
</head>
<body>
	<div class="container">
		<header class="bg-info d-flex align-items-center">
			<div class="text-white ml-3 m-0"><h1>배탈의 민족</h1></div>
		</header>
		<section>
			<h1>우리동네 가게</h1>
			<c:forEach items="${StoreList}" var="Store">
			<div class="store border-info mb-3 p-3">
				<a href="#" style="color: black">
					<div class="ml-2"><h2>${Store.name}</h2></div>
					<div class="ml-2"><h3>${Store.phoneNumber}</h3></div>
					<div class="ml-2"><h3>${Store.address}</h3></div>
				</a>
			</div>
			</c:forEach>
		</section>
		<hr>
		<footer>
			<h2>(주)우와한형제</h2>
			<h3 class="text-secondary">고객센터 : 1500-1500</h3>
		</footer>
	</div>
</body>
</html>