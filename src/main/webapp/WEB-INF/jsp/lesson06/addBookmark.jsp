<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>
<!-- bootstrap CDN link -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<!-- AJAX를 사용하려면 반드시 slim 버전이 아닌 jquery 원본 필요 -->
	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨 찾기 추가하기</h1>
		<div class="form-group">
			<label for="name"><b>제목</b></label>
			<input type="text" id="name" class="form-control col-12">
		</div> 
		<div class="form-group">
			<label for="url"><b>주소</b></label>
			<div class="d-flex"> <!-- form-inline == d-flex -->
				<input type="text" id="url" class="form-control col-11">
				<button type="button" id="urlCheckBtn" class="btn btn-info">중복확인</button>
			</div>
			<small id="duplicatedText" class="text-danger d-none">중복된 url 입니다.</small>
			<small id="availableText" class="text-success d-none">저장 가능한 url 입니다.</small>
		</div> 
		<input type="button" id="addBtn" class="btn btn-success btn-block" value="추가">
	</div>
	
<script>
	$(document).ready(function(){
		// quiz02) 중복 확인 버튼 클릭
		$('#urlCheckBtn').on('click', function(){
			//alert("클릭!");
			let url = $('#url').val().trim();
			
			if(url == ""){
				alert("검사할 url을 입력하세요.");
				return;
			}
			
			// DB에서 URL 중복확인 - AJAX
			$.ajax({
				// request
				type:"POST" // url이 길 수 있어서
				, url:"/lesson06/quiz02/is-duplicated-url"
				, data:{"url":url}
				
				// response
				, success:function(data){ // data => json => dictionary
					// {"code":200, "is_duplication":true} true:중복
					if (data.is_duplication){
						// 중복
						$("#duplicatedText").removeClass('d-none');
						$("#availableText").addClass('d-none');
					} else {
						// 중복 아님
						$("#duplicatedText").addClass('d-none');
						$("#availableText").removeClass('d-none');
					}
				}
				, error:function(request, status, error){
					alert("중복확인에 실패했습니다.");
				}
			});
		});
		
		//  url 추가 버튼 클릭
		$('#addBtn').on('click', function(){
			//alert("버튼!");
			
			// validation check
			let name = $('#name').val().trim();
			if(name == ""){
				alert("제목을 입력하세요");
				return;
			}
			let url = $('#url').val().trim();
			if(url == ""){
				alert("주소를 입력하세요");
				return;
			}
			
			if(url.startsWith("http://") == false &&
					url.startsWith("https://") == false){
				alert("주소 형식이 잘못 되었습니다.");
				return;
			}
			
			console.log(name);
			console.log(url);
			
			// quiz02) 저장가능한 url인지 체크
			if($('#availableText').hasClass('d-none')){ // availavleText d-none이 있으면 가입불가
				alert("url 중복확인을 다시 해주세요.");
				return;
			}
			
			//  quiz01 추가하기 기능
			$.ajax({
				// request
				type:"POST"
				,url:"/lesson06/quiz01/add-bookmark"
				,data:{"name":name, "url":url}
			
				// response
				, success:function(data){ // data: response 응답값(JSON String) => Dictionary Object
					// data는 JSON String => Object 변환된 형태로 사용할 수 있다.
					// jquery의 ajax 함수기능
					/* alert(data.code);
					alert(data.result); */
					if(data.result == "success"){
						location.href = "/lesson06/quiz01/get-bookmark-list"; // 리다이렉트랑 비슷!
					}
				}
				, error:function(request, status, error){
					alert("추가에 실패했습니다. 관리자에게 문의해주세요.");
				}
			})
		})
	})
</script>
</body>
</html>