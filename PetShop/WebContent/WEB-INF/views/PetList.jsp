<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*, net.ddns.petrizoo.models.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listing of all the pets in the inventory</title>
</head>
<body>
	<h3>I shall display all the pets in the world! (Or, our inventory)</h3>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Gender</th>
			<th>Type</th>
			<th>Cost</th>
			<th>Picture</th>
		</tr>
		<%
			List<Pet> petList = (List<Pet>) session.getAttribute("pet_list");
			for (int i = 0; i < petList.size(); i++) {
		%>
		<tr>
			<td><%=petList.get(i).getId()%></td>
			<td><%=petList.get(i).getName()%></td>
			<td><%=petList.get(i).getGender()%></td>
			<td><%=petList.get(i).getPetType()%></td>
			<td><%=petList.get(i).getCost()%></td>
			<td><img src="Media?id=<%=petList.get(i).getId()%>" height=100 width=125></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>