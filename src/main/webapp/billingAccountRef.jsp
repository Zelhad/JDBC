<%@page import="entities.BillingAccountRef"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List all Billing account</title>
</head>
<body>
<h1>List all Billing account</h1>
<div  class="mainContainer">
<table table border="1" cellpadding="5" cellspacing="0" class="table">
<thead>
<tr>
 <th>id</th>
 <th>base_type</th>
 <th>referred_type</th>
 <th>schema_location</th>
 <th>type</th>
 <th>href</th>
 <th>name</th>
 <tr>
</thead>
<tbody>
<%
List<BillingAccountRef> refs =(List<BillingAccountRef>)request.getAttribute("billingAccountRefs");
if(refs != null){
	for(BillingAccountRef bar : refs){%>
	<tr>
	<td><%= bar.getId() %></td>
	<td><%= bar.getBaseType() %></td>
	<td><%= bar.getReferredType() %></td>
	<td><%= bar.getSchemaLocation() %></td>
	<td><%= bar.getType()%></td>
	<td><%= bar.getHref()%></td>
	<td><%= bar.getName()%></td>
	</tr>
	<% }%>
<% }%>
</tbody>
</table>
</div>
</body>
</html>