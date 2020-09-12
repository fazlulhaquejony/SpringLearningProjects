<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix ="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="/WEB-INF/view/template/header.jsp"%>

       <div class="container-wrapper">
            <div class="container">
               <div="page-header">
                  <h1>All product for Administration revise</h1>
                  <p>This Product Inventory is for Administrator where Product can add, edit and delete </p>
               </div>
       
      <table class="table table-striped table-hover">
         <thead>
            <tr class="bg-success">
              <th>Photo Thumb</th>
              <th>Product Name</th>
              <th>Product Condition</th>
              <th>Product Category</th>
              <th>Product Price</th>
              <th>Action</th>
            </tr>
         </thead>
         <c:forEach items ="${product}" var="product">
            <tr>
               <td><img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image" style="width:100%"></td>
               <td>${product.productName}</td>
               <td>${product.productCondition}</td>
               <td>${product.productCatagory}</td>
               <td>${product.productPrice}BDT</td>
               <td><a href="<spring:url value ="/productlist/productview/${product.productId}"/>"><span class ="glyphicon glyphicon-info-sign"></span></a>
                <a href="<spring:url value ="/admin/productInventory/${product.productId}"/>"><span class ="glyphicon glyphicon-remove"></span></a>
                <a href="<spring:url value ="/admin/productInventory/productEdit/${product.productId}"/>"><span class ="glyphicon glyphicon-pencil"></span></a>
               </td>
             </tr>  
         
         </c:forEach>
 </table>
 <a href="<spring:url value="/admin/productInventory/productAdd"/>" class="btn btn-primary">Add product</a>

<%@ include file="/WEB-INF/view/template/footer.jsp" %>
