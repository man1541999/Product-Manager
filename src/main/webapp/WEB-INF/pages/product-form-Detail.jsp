<%-- 
    Document   : product-form-Detail
    Created on : Jun 21, 2022, 4:39:48 PM
    Author     : trunghuynh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<link href="<c:url value="/webjars/bootstrap/4.6.1/css/bootstrap.min.css" />" 
      rel="stylesheet" type="text/css" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <mvc:form method="POST" modelAttribute="productDetail"
                  action="${pageContext.request.contextPath}/result">
            <div class="container">
                <div class="row">
                    <h2>Product detail</h2>
                </div>
                <div class="row" justify-content-center" style="margin: 10px 0">
                    <div class="col-12 col-lg-6">
                        <div class="form-group">
                            <label>Color</label>
                            <select class="form-control" name="color">
                                <c:forEach items="${color}" var="co">
                                    <option value="${co}">${co}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-12 col-lg-6">
                        <div class="form-group">
                            <label>Size</label>
                            <select class="form-control" name="size">
                                <c:forEach items="${size}" var="s">
                                    <option value="${s}" >${s}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12 col-lg-6">                       
                        <input hidden name="product.id" value="${product.id}"/>
                    </div>
                </div>

                <div class ="row justify-content-right" >
                    <div class="col-12" style="text-align: right">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </div>
        </mvc:form>
    </body>
</html>
