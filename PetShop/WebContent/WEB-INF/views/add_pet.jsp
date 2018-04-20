<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="net.ddns.petrizoo.models.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add some pets!</title>
</head>
<body>
	<form method="post" action="AddPet" enctype="multipart/form-data">
		<fieldset>
			<legend>Add a new pet!</legend>
			Pet Type: <select name="pet_type">
				<%
					for (PetType type : PetType.values()) {
				%>
				<option value="<%=type%>"><%=type%></option>
				<%
					}
				%>
			</select> <BR> Pet Name: <input type="text" name="pet_name" /> <BR>
			Pet Cost ($): <input type="text" name="pet_cost" /> <BR> Pet
			Picture: <input type="file" name="pet_pic" /> <BR> Pet Gender:
			<select name="pet_gender">
				<%
					for (Gender gend : Gender.values()) {
				%>
				<option value="<%=gend%>"><%=gend%></option>
				<%
					}
				%>
			</select> <BR> Fixed? <select name="pet_fixed">
				<option value="true">Yes</option>
				<option value="false">No</option>
			</select><BR> <input type="submit" value="Add pet!" />
		</fieldset>
	</form>
</body>
</html>