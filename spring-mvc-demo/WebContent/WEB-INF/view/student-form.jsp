<%@ taglib prefix ="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
   <title> Student Registration Form </title>
</head>

<body>
   <form:form action="processForm" modelAttribute="student">
   First name: <form:input path="firstName" />
   
   <br><br>
   
   Last name: <form:input path="lastName" />
   
   <br><br>
    <form:select path="country">
          <!-- MNUALLY FROM FORM -->
         <!--<form:option value="Bangladesh" label ="Bangladesh"></form:option>
          <form:option value="India" label ="India"></form:option>
          <form:option value="Nepal" label ="Nepal"></form:option>
          <form:option value="Vutan" label ="Vutan"></form:option> -->
          
           <form:options items= "${student.countryOptions}" />
    </form:select>  
   
   <br><br>
   
   Favorite Language:
   Java <form:radiobutton path="favoriteLanguage" value="Java"/>
   C# <form:radiobutton path="favoriteLanguage" value="C#"/>
   PHP <form:radiobutton path="favoriteLanguage" value="PHp"/>
   Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>  
   
   <br><br>
   
   Operating System:
   Linux <form:checkbox path="operatingSystems" value ="Linux"/>
   Mac OS <form:checkbox path="operatingSystems" value ="Mac OS"/>
   MS Windows <form:checkbox path="operatingSystems" value ="MS Windows"/>
   
 

   <br><br>
       
   <input type="submit" value="Submit">
   
   </form:form>


</body>
</html>