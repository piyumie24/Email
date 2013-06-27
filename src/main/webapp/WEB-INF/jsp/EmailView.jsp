<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>



<table border="1">
    <c:forEach var="person" items="${listEmailMessage}">
        <tr>
          Email was send successfully to  <td>${person.name}
        </tr>

    </c:forEach>
</table>
</body>
</html>
