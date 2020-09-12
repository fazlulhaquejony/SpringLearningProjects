<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/view/template/header.jsp"%>

 <div class="container-wrapper">
     <div class="container">
         <div class="page-header">
           <h1>Add Product</h1>
           <p class="lead"> Fill all the information to add a product</p> 
         </div>

  <form:form action="${pageContext.request.contextPath}/admin/productInventory/productAdd" method="post" modelAttribute="product" enctype="multipart/form-data">

   <div class="form-group">
    <label for="name">Name</label><form:errors path="productName" cssStyle="color: #ff0000;"></form:errors>
     <form:input path="productName" id="name" class="form-control"/>
   </div>
   
   <div class="form-group">
   <label for="category">Cycle Category</label>
   <div>
   <label class="checkbox-inline">
   <form:radiobutton path="productCatagory" id="category" value="classiccycle"/>Classic Cycle</label>
   <label class="checkbox-inline">
   <form:radiobutton path="productCatagory" id="category" value="Kidscycle"/>Kids cycle</label>
   <label class="checkbox-inline">
   <form:radiobutton path="productCatagory" id="category" value="sportscycle"/>Sports Cycle</label>
   </div>
   </div>
  
  <div class="form-group">
  <label for="description">Description</label>
  <form:textarea path="productdescription" id="description" class="form-control"/>
  </div>
  
  <div class="form-group">
  <label for="price">Price</label><form:errors path="productPrice" cssStyle="color: #ff0000;"></form:errors>
  <form:input path="productPrice" id="price" class="form-control"/>
  </div>
  
  <div class="form-group">
  <label for="condition">Product Condition</label>
  <div>
  <label class="checkbox-inline">
  <form:radiobutton path="productCondition" id="condition" value="new"/>New</label>
  </div>
  
 <label class="checkbox-inline">
  <form:radiobutton path="productCondition" id="condition" value="used" />Used</label>
  </div>
 
<div class="form-group">
 <label for="instock">Unit In Stock</label><form:errors path="productInStock" cssStyle="color: #ff0000;"></form:errors>
 <form:input path="productInStock" class="form-control"/>
</div>
  
 <div class="form-group">
 <label class="control-label" for="productImage">Upload Image</label>
 <form:input id="productImage" path="productImage" type="file" class="form:input-large" />
 </div> 
 
 <div class="form-group">
 <label for="manufacturer">Manufacturer</label>
 <form:input path="productmanufacturer"  class="form-control"/>
 </div>
 
 <br><br>
 <input type="submit" value="submit" class="btn btn-default">
 <a href="<c:url value="/admin/productInventory"/>" class="btn btn-default">Cancel</a>
 
 </form:form> 
   <%@ include file="/WEB-INF/view/template/footer.jsp"%>