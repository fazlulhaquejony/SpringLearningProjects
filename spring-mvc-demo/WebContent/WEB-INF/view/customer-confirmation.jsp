<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %>

<!DOCTYPE  html>
<html>

<head>

<title>Customer Confirmation</title>

</head>
<body>

The Customer is confirmed: ${customer.firstName} ${customer.lastName}
<br><br>
Free passes: ${customer.freePasses}
<br><br>
Free passes: ${customer.postalCode}

<br><br>
Free passes: ${customer.courseCode}
</body>
</html>