<%-- 
    Document   : index
    Created on : Jul 2, 2019, 2:50:17 PM
    Author     : Derslived
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Projects!</h1>
        <hr/>
        <p>
            <a href="${pageContext.request.contextPath}/admin/projects/add"> Add </a>
        </p>
        <table border="1" style="width:100%" >
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Created Date</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            <c:forEach var="projectName" items="${requestScope.projectList}" >
                <tr>
                    <td>${projectName.id}</td>
                    <td>${projectName.name}</td>
                    <td>${projectName.startDate}</td>
                    <td>${projectName.endDate}</td>
                    <td>${projectName.createdDate}</td>
                    <td>${projectName.status}</td>

                    <td><a href="${pageContext.request.contextPath}/admin/projects/edit/${project.id()}"> Edit </a>              
                        Delete</td>

                </tr>

            </c:forEach> 

        </table>
    </body>
</html>
