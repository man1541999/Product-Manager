<%-- 
    Document   : product-form1
    Created on : Jul 6, 2022, 2:39:30 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="<c:url value="/webjars/bootstrap/4.6.1/css/bootstrap.min.css" />" 
      rel="stylesheet" type="text/css" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center" style="margin: 10px 0">
                <c:if test="${action == 'add'}">
                    <h2>Create new Book</h2>
                </c:if>

                <c:if test="${action == 'update'}">
                    <h2>Update Book</h2>
                </c:if>
            </div>
            <mvc:form method="POST" modelAttribute="product"
                      action="${pageContext.request.contextPath}/handle" enctype="multipart/form-data">
                <c:if test="${action == 'update'}">
                    <input hidden value="${product.id}" name="id" />
                    <input hidden value="${product.productDetail.id}" name="productDetail.id" />
                </c:if>
                <div class="row">
                    <div class="col-12 col-lg-6">
                        <div class="form-group">
                            <label>Category</label>
                            <select class="form-control" name="category.id" >
                                <c:forEach items="${categories}" var="cate">
                                    <c:if test="${product.category.id == cate.id}">
                                        <option value="${cate.id}" selected="${cate.id}">${cate.name}</option>
                                    </c:if>
                                    <c:if test="${product.category.id != cate.id}">
                                        <option value="${cate.id}">${cate.name}</option>
                                    </c:if>
                                </c:forEach> 
                            </select>
                        </div>
                    </div>
                    <div class="col-12 col-lg-6">
                        <div class="form-group">
                            <label for="nameId">Name</label>
                            <input type="text" class="form-control" id="nameId" name="name"
                                   value="${product.name}"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12 col-lg-6">
                        <div class="form-group">
                            <label for="priceId">Price</label>
                            <input type="number" class="form-control" id="priceId" name="price"
                                   value="${product.price}"/>
                        </div>
                    </div>
                    <div class="col-12 col-lg-6">
                        <div class="form-group">
                            <label for="DateId">Create Date</label>
                            <input type="date" class="form-control" id="DateId" name="createDate"
                                   value="${product.createDate}"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12 col-lg-6">
                        <div class="form-group">
                            <label for="descriptionId">Description</label>
                            <textarea type="text" class="form-control" id="descriptionId" name="description"
                                      value="${product.description}"></textarea>
                        </div>
                    </div>
                   <div class="col-12 col-lg-6">
                        <div class="form-group">
                            <label for="imageId">Image</label>
                            <input type="file" class="form-control" id="imageId" name="fileData"
                                   value="${product.imageName}"/>
                        </div>
                    </div>

                </div>
                <div class ="row justify-content-right" >
                    <div class="col-12" style="text-align: right">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </mvc:form>


        </div>

    </body>
</html>
