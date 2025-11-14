<%@page import="entities.AgreementItemRef"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.Product" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<html>
<head>
    <title>AgreementItemRefs</title>
</head>
<body>
<h2>AgreementItemRefs</h2>

<table border="1" cellpadding="5" cellspacing="0" class="table">
    <tr>
        <th>ID</th>
        <th>Href</th>
        <th>agreement_item_id</th>
        <th>NAME</th>
        <th>base_type</th>
        <th>schema_location</th>
        <th>type</th>
        <th>referred_type</th>
    </tr>
    <%
        List<AgreementItemRef> agreementItemRefs = (List<AgreementItemRef>) request.getAttribute("agreementItemRefs");
        if (agreementItemRefs != null) {
            for (AgreementItemRef agr : agreementItemRefs) {
    %>
        <tr>
            <td><%= agr.getId() %></td>
            <td><%= agr.getHref() %></td>
            <td><%= agr.getAgreementItemId() %></td>
            <td><%= agr.getName() %></td>
            <td><%= agr.getBaseType() %></td>
            <td><%= agr.getSchemaLocation() %></td>
            <td><%= agr.getType() %></td>
            <td><%= agr.getReferredType() %></td>
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
