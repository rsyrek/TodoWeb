<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
		<title>Rafal's todo list</title>
	</head>
	<body>
		<h1>Yours todos:</h1>
		<form name="input" action="page/update/" method="get">
		<c:forEach items="${todoList}" var="todo">
			<c:choose>
				<c:when test="${todo.done == true}">
						<input type="checkbox" name="chckTodo" value="${todo.id}" checked="checked">
						<font style="color:grey"><font style="text-decoration: line-through;"><i>
							${todo.text}
						</i></font></font>
				</c:when>
               	<c:otherwise>
               		<input type="checkbox" name="chckTodo" value="${todo.id}" onclick="this.style.text-decoration: line-through;">${todo.text}
               	</c:otherwise>
           	</c:choose>
			<br />
		</c:forEach>
		<input type="submit" value="Submit">
		</form>
		<form action="delete" method="post">
			<input type="submit" value="Clear done tasks"/>
		</form>
		<form method="post">
			Task: <input type="text" name="text" /><br/>
			<input type="submit" value="Add"/>
		</form>
	</body>
</html>