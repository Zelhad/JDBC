<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.Product" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<html>
<head>
    <title>Products</title>
</head>
<body>
<h2>Product List</h2>

<table border="1" cellpadding="5" cellspacing="0" class="table">
    <tr>
        <th>ID</th>
        <th>Href</th>
        <th>Name</th>
        <th>Description</th>
        <th>Visible</th>
        <th>Order Date</th>
        <th>Serial Number</th>
        <th>Start Date</th>
        <th>Termination Date</th>
    </tr>
    <%
        List<Product> products = (List<Product>) request.getAttribute("products");
        if (products != null) {
            for (Product p : products) {
    %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getHref() %></td>
            <td><%= p.getName() %></td>
            <td><%= p.getDescription() %></td>
            <td><%= p.is_customer_visible() %></td>
            <td><%= p.getOrder_date() %></td>
            <td><%= p.getProduct_serial_number() %></td>
            <td><%= p.getStart_date() %></td>
            <td><%= p.getTermination_date() %></td>
        </tr>
    <%
            }
        } else {
    %>
        <tr><td colspan="8">No products found.</td></tr>
    <%
        }
    %>
</table>

</body>
</html>
