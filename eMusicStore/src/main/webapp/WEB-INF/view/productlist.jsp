<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@include file="/WEB-INF/view/template/header.jsp"%>

 <div class="container-wrapper">
    <div class="container">
     <div class="page-header">
      <h1>All Products</h1>
      <p class="lead"> Checkout all the Awesome product now!</p>
     </div>
     <table class ="table table-striped table-hover">
     <thead>
        <tr class="bg-success">
          <th>Photo thumb </th>
          <th>Product Name </th>
          <th>Category </th>
          <th>Conditions </th>
          <th>Price </th>
          <th>View </th>
        </tr>
     </thead>
     <c:forEach items="${products}" var="product">
      <tr>
         <td><img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image" style="width:100%"></td>
         <td>${product.productName}</td>
         <td>${product.productCondition}</td>
         <td>${product.productCatagory}</td>
         <td>${product.productPrice}</td>
        <td><a href="<spring:url value="/productlist/productview/${product.productId}" />"> 
          <span class="glyphicon glyphicon-info-sign"></span></a></td>
     </tr>
     </c:forEach>
   </table>
        
 
   <%@ include file="/WEB-INF/view/template/footer.jsp"%>