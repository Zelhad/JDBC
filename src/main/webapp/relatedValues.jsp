<%@page import="entities.RelatedPlaceRefOrValue"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List all  Product related places</h1>
	<table border="1" cellpadding="5" cellspacing="0" class="table">
		<thead>
			<tr>
				<th>id</th>
				<th>href</th>
				<th>name</th>
				<th>role</th>
				<th>base_type</th>
				<th>schema_location</th>
				<th>type</th>
				<th>referred_type</th>
			</tr>
		</thead>
		<tbody>

			<%
			List<RelatedPlaceRefOrValue> placesOrValues = (List<RelatedPlaceRefOrValue>) request
					.getAttribute("relatedPlaceRefOrValues");
			for (RelatedPlaceRefOrValue placeOrvalue : placesOrValues) {
			%>
			<tr>
				<td><%=placeOrvalue.getId()%></td>
				<td><%=placeOrvalue.getHref()%></td>
				<td><%=placeOrvalue.getName()%></td>
				<td><%=placeOrvalue.getRole()%></td>
				<td><%=placeOrvalue.getBase_type()%></td>
				<td><%=placeOrvalue.getSchema_location()%></td>
				<td><%=placeOrvalue.getType()%></td>
				<td><%=placeOrvalue.getType()%></td>
			</tr>
			<%
			}
			%>


		</tbody>


	</table>

</body>
</html>