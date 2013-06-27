<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head><title>Email Form</title>
</head>
<body>

<form:form commandName="email" method="POST" action="sendEmail">

    <p>Email Form </p>

<c:forEach var="person" items="${listEmailMessage}">

    Receiver Email
    <form:input  path="receiverEmailAddress" value="${person.email}"/>




    Name
    <form:input path="subject" value="hi Mr/Miss/Mis ${person.name}"/>




    Message Body
    <form:input path="messageBody" value="${person.message}"/>




    </br>
    <input type="submit" value="Send Email" />
</c:forEach>


</form:form>

</body>
</html>