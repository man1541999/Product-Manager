<%-- 
    Document   : product-form
    Created on : Jun 16, 2022, 3:04:24 PM
    Author     : trunghuynh
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
            
            <mvc:form method="POST" modelAttribute="product"
                      action="${pageContext.request.contextPath}/handle" enctype="multipart/form-data">

                <table>
                    <tr>
                        <td><mvc:label path="name">Name</mvc:label></td>
                        <td><mvc:input path="name"/></td>
                    </tr>
                    <tr>
                        <td>
                            <mvc:input  path="fileData" type="file" />

                        </td>
                        <td><mvc:button type="submit">Submit</mvc:button></td>
                        </tr>
                    </table>


            </mvc:form>


        </div>

    </body>
</html>
