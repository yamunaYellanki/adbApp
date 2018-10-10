<%@taglib uri = "http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
	<head>
		<title>Employees List</title>
		<link href="styles/site.css" rel="stylesheet"/>
	</head>
	<body>
		<h3>Employees List</h3>
		
		<a href="addEmployee">Add Employee</a>
		
		<c:choose>
			<c:when test="${employees eq null or employees.size() eq 0 }">
				<h3>No records found</h3>
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<th>EmpID</th>
						<th>Name</th>
						<th>Basic</th>
						<th>HRA</th>
						<th>Date of Birth</th>
					</tr>
					<c:forEach items="${employees  }" var="employee">
						<tr>
							<td>${employee.contactId }</td>
							<td>${employee.firstName } ${contact.lastName } </td>
							<td>${employee.mobileNumber }</td>
							<td>${employee.emailId }</td>
							<td>${employee.dateOfBirth}</td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</body>
</html>