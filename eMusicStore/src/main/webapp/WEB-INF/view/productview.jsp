<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@include file="/WEB-INF/view/template/header.jsp"%>

 <body>
<div class="container-wrapper">
  <div class="container">
     <div class="page-header">
        <h1>Product Details</h1>
        
        <p class="lead">Here all the information of the product!!</p>
     </div>
     <div class="container">
        <div class="row">
           <div class="col-md-5">
              <img src="<c:url value="/resources/images/${product.productId}.png"/>" alt="image" style="width:100%; height: 300px" />
           </div>
          <div class="col-md-5">
          <h3>${product.productName}</h3>
          <p>${product.productdescription}</p>
          <p>
          <strong>Menufracturer</strong> : ${product.productmanufacturer}
          </p>
          <p>
          <strong>category</strong> : ${product.productCatagory}
          </p>
          <p>
          <strong>condition</strong> : ${product.productCondition}
          </p>
          <h4>${product.productPrice} taka </h4>
          <p>Price</p>
     </div>
  </div>
</div>

<%@ include file="/WEB-INF/view/template/footer.jsp" %>
