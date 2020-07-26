<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
    
    <hr>
    <!-- display user name and role -->
    <p>
    User: <security:authentication property="principal.username"/>
    <br><br>
    Role(s) : <security:authentication property="principal.authorities"/>
    </p>
    
    
    <hr>
    
    <hr>
    
    <!-- Add a link to point to /leaders... this is for the managers  -->
    
    <security:authorize access="hasRole('MANAGER')">
    <p >
       <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
       (Only for Manager peeps)
    
    </p>
    </security:authorize>
    
    <security:authorize access="hasRole('ADMIN')">
    <!--  Add a link to poin to/systems... this is for admins-->
    
        <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
       (Only for Admin peeps)   
    <hr>
    </security:authorize>
    
    <!-- add login button -->
    <form:form action="${pageContext.request.contextPath}/logout"
			   method="POST">
			   
		<input type="submit" value="Logout" />
		
	</form:form>
</body>
</html>