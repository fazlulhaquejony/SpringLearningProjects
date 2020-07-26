<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>USer Login Form</title>
<body>

<i>Fill up of (*) is required</i>

<form:form action="valueProcessing" modelAttribute="user">
Enter User Name: <form:input path="userName"/>
<br><br>
Enter Password:  <form:input path="Password"/>
<br><br>
Choice:
<form:select path="choice">
    <form:options items="${user.choiceOption}"/>
</form:select>
<br><br>

<input type="submit" value ="Submit"/>

</form:form>
</body>

</html>



