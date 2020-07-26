<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>

<tittle>fjthechsolitions company home page</tittle>
</head>

<body>
   <h2>Company home page-go-jony-go</h2>
    <hr>
    <p>
    Welcome to the fjtechsolutions company home page!
    </p>
    
    <!-- add login button -->
    <form:form action="${pageContext.request.contextPath}/logout"
			   method="POST">
			   
		<input type="submit" value="Logout" />
		
	</form:form>
</body>
</html>