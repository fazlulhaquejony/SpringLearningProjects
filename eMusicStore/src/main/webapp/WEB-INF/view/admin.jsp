<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@include file="/WEB-INF/view/template/header.jsp"%>


    <div class = "container-wrapper">
        <div class = "container">
           <div class="page-header">
            <h1>Administrator Page</h1>
            
            <h3>
              <a href="<c:url value="/admin/productInventory" /> ">Product Inventory</a>
            </h3>
            </div>
           <p>This part is for add , edit and delete product </p>
      </div>
      </div>     
           
     <div class = "container-wrapper">
        <div class = "container">
           <div class="page-header">
            <h1>Administrator Page</h1>
            
            <h3>
              <a href="<c:url value="/admin/productInventory/productAdd" /> ">Add Product</a>
            </h3>
            </div>
           <p>This part is for add  product </p>
                  
           
  <%@ include file="/WEB-INF/view/template/footer.jsp" %>
      