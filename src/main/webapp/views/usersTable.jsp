<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>TABLE</title>
</head>
<body>

<table class="table table-striped">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Password</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="list" items="${list}">
        <tr>
            <td>${list.id}</td>
            <td>${list.name}</td>
            <td>${list.password}</td>
            <form method="get" action="admin/update">
                <td>
                    <button type="submit" name="update" value=${list.id}>Update</button>
                </td>
            </form>
            <form method="post" action="admin/delete">
                <td>
                    <button type="submit" name="delete" value=${list.id}>Delete</button>
                </td>
            </form>
        </tr>
    </c:forEach>
    </tbody>
</table>
<table>
    <form method="post" action="admin/createNew">
        <tr>
            <td>
                <button type="submit" name="create">Add new user</button>
            </td>
        </tr>
    </form>
</table>

</body>
</html>
