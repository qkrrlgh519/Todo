<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할 일 등록 화면</title>

<link rel="stylesheet" type="text/css" href="CSS/todoForm.css">

</head>
<body>

	<header>
		<h1>할일 등록</h1>
	</header>
	
	<section>
		<form action="/Todo/todoAdd" method="post">
			<div class="div-title">
				어떤일인가요?
			</div>
			<input id="title-input" type="text" name="title" maxlength="24" placeholder="switf 공부하기(24자까지)" required><br>
			<br>
			
			<div class="div-title">
				누가 할일인가요?
			</div>
			<input id="name-input" type="text" name="name" placeholder="홍길동" required>
			<br><br>
			
			<div class="div-title">
				우선순위를 선택하세요.
			</div>
			<div class="div-radio">
				<input type="radio" name="sequence" value="1" id="radio-1" required>
					<label for="radio-1">1순위&nbsp;&nbsp;&nbsp;&nbsp;</label>
				<input type="radio" name="sequence" value="2" id="radio-2" required>
					<label for="radio-2">2순위&nbsp;&nbsp;&nbsp;&nbsp;</label>
				<input type="radio" name="sequence" value="3" id="radio-3" required>
					<label for="radio-3">3순위</label>
			</div>
			<br><br>
			
			<a href="/Todo/main"><button type="button">&lt; 이전</button></a>
			<button type="submit">제출</button>
			<button type="reset">내용지우기</button>
		</form>
	</section>

</body>
</html>