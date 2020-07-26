<%@taglib prefix="form" uri ="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Send your email</title>
</head>

<body>

<form:form action="processEmail" modelAttribute="email">
To: <form:input path= "to" />

<br><br>
Subject: <form:input path= "sub" /> 

<br><br>
Body: <form:input path= "Body" />

<br><br>

<input type="submit" value = "submit">

</form:form>

</body>
</html>