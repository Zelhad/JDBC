<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<h2>Product List</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Visible</th>
        <th>Order Date</th>
    </tr>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.description}</td>
            <td>${p.is_customer_visible}</td>
            <td>${p.order_date}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
