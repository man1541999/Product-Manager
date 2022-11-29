<%-- 
    Document   : home
    Created on : Jun 12, 2022, 11:54:25 PM
    Author     : trunghuynh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Page</title>
        <link href="<c:url value="/webjars/bootstrap/4.6.1/css/bootstrap.min.css" />" 
              rel="stylesheet" type="text/css" />
    </head>
    <body>

        <div class="container " >
            <div class="row justify-content-center">
                <h2>List Product </h2>              
            </div>
            <div class="col-12" style="padding-bottom: 10PX">                
                <button class="btn btn-outline-success my-2 my-sm-0" 
                        type="button"
                        onclick="location.href = '<c:url value="/add"/>'">Add product</button>
            </div>
            <div class ="row">
                <div class="col-12">
                    <div class="table-responsive">
                        <table class="table table-bordered">
                            <tr style="text-align: center">
                                <th>Picture</th>
                                <th>Name</th>
                                <th>Category</th>
                                <th>Size</th>
                                <th>Color</th>
                                <th>Price</th>
                                <th>Day</th>
                                <th>Description</th>
                                <th colspan="2">Action</th>
                            </tr>
                            <c:forEach items="${products}" var="p">
                                <tr class="table-info"> 
                                    <td>
                                        <ul>                                            
                                            <img width="100" alt="image" class="img-thumbnail" src="<c:url value="/resources/image/${p.imageName}" />" />
                                           
                                        </ul>

                                    </td>
                                    <td>${p.name}</td>
                                    <td>${p.category.name}</td>
                                    <td>${p.productDetail.size}</td>
                                    <td>${p.productDetail.color}</td>
                                    <td>${p.price}</td>
                                    <td>${p.createDate}</td>
                                    <td>${p.description}</td>
                                    <td><button type="button" class="btn btn-warning"
                                                onclick="location.href = '<c:url value="/update/${p.id}"/>'">Update</button>
                                        <button type="button" class="btn btn-danger" 
                                                onclick="location.href = '<c:url value="/delete/${p.id}"/>'">Delete</button>
                                    </td>
                                   
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </body>
</html>
