<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨 찾기 목록</title>
<!-- bootstrap CDN link -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<!-- AJAX를 사용하려면 반드시 slim 버전이 아닌 jquery 원본 필요 -->
	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨 찾기 목록</h1>
		<table class="table">
			<thead>
				<tr>
					<th>No.</th>
					<th>이름</th>
					<th>주소</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${bookmarks}" var="bookmark">
				<tr>
					<td>${bookmark.id}</td>
					<td>${bookmark.name}</td>
					<td><a href="${bookmark.url}" target="_blank">${bookmark.url}</a></td> <!-- target은 새탭 -->
					<td>
						<%-- 1) value속성을 이용해서 값 세팅 --%>
						<%-- <button type="button" class="deleteBtn btn btn-danger" value="${bookmark.id}">삭제</button> --%>
						
						<%-- 2) data를 이용해서 태그에 값 세팅: 대문자 X --%>
						<button type="button" class="deleteBtn btn btn-danger" data-bookmark-id="${bookmark.id}">삭제</button>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>

<script>
	$(document).ready(function(){
		// 삭제 버튼 클릭
		$('.deleteBtn').on('click',function(e){
			//alert("삭제!");
			// 1) value
			//let id = $(this).val();
		
			// 2) value
			//let id = e.target.value;
	
			// 3) data
			//data-bookmark-id => data("bookmark-id")함수를 사용
			let id = $(this).data('bookmark-id');
			//alert(id);
			
			// db에서 삭제 => ajax
			$.ajax({
				// request
				type:"DELETE"
				, url:"/lesson06/quiz02/delete-bookmark"
				, data:{"id":id}
				
				// response
				,success:function(data){
					if(data.code == 200){
						location.reload(true); // 새로고침
					} else{
						alert("삭제를 실패했습니다. 다시 시도해 주세요.") // 성공은 했으나 200코드가 아니라 로직상 문제가 있을 수 있음
					}
				}
				, error:function(request, status, error){
					alert("삭제를 실패했습니다. 관리자에게 문의해주세요."); // 삭제 자체가 실패함
				}
			});
			
		});
	});
</script>
</body>
</html>