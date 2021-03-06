<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


<html>

	<head>
		<title>Search Page</title>
		<link href="styles/site.css" rel="stylesheet"/>
	</head>

	<body>
	<h2>Search Employee</h2>
		
	<form action="searchEmployee" method="POST">
		<label>Search For : <input type="text" name="srhValue"></label>
			<button name="field" value="mobile">By Mobile</button>
			<button name="field" value="email">By Email</button>
			<button name="field" value="lnm">By Last Name</button>
			
	</form>
	
	<c:if test="${pageTitle ne null }">
	
	<h2>${pageTitle  }</h2>
	
		<c:choose>
			<c:when test="${result ne null }">

				<table>
					<tr>
						<td><strong>EmployeeID</strong></td>
						<td>${result.employeeId}</td>
					</tr>
					<tr>
						<td><strong>Name</strong></td>
						<td>${result.firstName}${result.lastName}</td>
					</tr>

					<tr>
						<td><strong>Mobile</strong></td>
						<td>${result.mobileNumber }</td>
					</tr>
					<tr>
						<td><strong>Email Id</strong></td>
						<td>${result.emailId }</td>
					</tr>
					<tr>
						<td><strong>Date Of Birth</strong></td>
						<td>${result.dateOfBirth }</td>
					</tr>
				</table>
			</c:when>
			<c:when test="${results ne null and results.size() ne 0}">
				<table>
					<tr>
						<th>EmployeeId</th>
						<th>Name</th>
						<th>Mobile</th>
						<th>Email</th>
						<th>Date Of Birth</th>
					</tr>
					<c:forEach items="${results }" var="employee">
						<tr>
							<td>${employee.contactId }</td>
							<td>${employee.firstName }${employee.lastName }</td>
							<td>${employee.mobileNumber }</td>
 							<td>${employee.emailId }</td>
							<td>${employee.dateOfBirth }</td>
						</tr>
					</c:forEach>
				</table>

			</c:when>

			<c:when test="${results ne null and results.size() ne 0 }">
			
			<table>
					<tr>
						<th>EmployeeID</th>
						<th>Name</th>
						<th>Mobile</th>
						<th>Email</th>
						<th>Date of Birth</th>
					</tr>
					<c:forEach items="${results  }" var="employee">
						<tr>
							<td>${employee.contactId }</td>
							<td>${employee.firstName }${employee.lastName }</td>
							<td>${employee.mobileNumber }</td>
 							<td>${employee.emailId }</td>
							<td>${employee.dateOfBirth }</td>
						</tr>
					</c:forEach>
				</table>
		
			</c:when>
			<c:otherwise>
				<h3>No Such Records Found</h3>
			</c:otherwise>
		</c:choose>
	
	</c:if>
	
	</body>
	
</html>