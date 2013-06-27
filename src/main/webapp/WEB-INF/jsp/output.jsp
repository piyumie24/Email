<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>



	<table border="1">
		<c:forEach var="person" items="${listEmailMessage}">
			<tr>
				<td>${person.name}</td><td>${person.email}</td><td>${person.message}</td>
			</tr>

		</c:forEach>
	</table>	
</body>
</html>
