<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할 일 목록 화면</title>

<link rel="stylesheet" type="text/css" href="CSS/main.css">
<script src="JS/main.js"> </script>

</head>
<body>

	<header>
		<h2>나의 해야할 일들</h2>
		<a href="/Todo/todoForm"><button id="new-todo">새로운 TODO 등록</button></a>
	</header>
	
	<section>
		<div class="todo-section">
			<div class="todo-type">DONE</div>
			<c:forEach var="todo" items="${requestScope.doneList}">
				<div class="todo-content">
					<p class="todo-title">${todo.title}</p>
					<p class="todo-detail">등록날짜:${todo.regDate}, ${todo.name}, 우선순위 ${todo.sequence}</p>
				</div>
			</c:forEach>	
		</div>	
	
		<div class="todo-section">
			<div class="todo-type">DOING</div>
			<c:forEach var="todo" items="${requestScope.doingList}">
				<div class="todo-content">
					<p class="todo-title">${todo.title}</p>
					<p class="todo-detail">등록날짜:${todo.regDate}, ${todo.name}, 우선순위 ${todo.sequence}</p>
					<button class="todo-button" onclick="moveType('${todo.id}')">➔</button>
				</div>
			</c:forEach>		
		</div>
		
		<div class="todo-section">
			<div class="todo-type">TODO</div>
			<c:forEach var="todo" items="${requestScope.todoList}">
				<div class="todo-content">
					<p class="todo-title">${todo.title}</p>
					<p class="todo-detail">등록날짜:${todo.regDate}, ${todo.name}, 우선순위 ${todo.sequence}</p>
					<button class="todo-button" onclick="moveType('${todo.id}')">➔</button>
				</div>
			</c:forEach>
		</div>		
	</section>
	
</body>
</html>