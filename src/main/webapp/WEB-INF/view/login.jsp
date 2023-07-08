	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <title>login</title>
</head>

<body align="center"bgcolor="skyblue">
    <div class="container" style="max-width:300px;border:1px solid black;display:flex;background:black;transform:translate(-40,50);">
       <form:form action="addUser" class="card" method="post" modelAttribute="userForm" id="user-form">
		<div class="card-body">
			<!-- Display the error message -->
        <c:if test="${not empty errorMessage}">
        	<div class="error-message" style="color:red">${errorMessage}</div>
    	</c:if>
		<br>
		
		<label for="username"style="color:black;">Username:</label><br>
		<form:input path="username" class="form-control" type="text" /><br>
		<form:errors style="color:red" path="username" />
		<br>

		
		<label for="password"style="color:black;">Password:</label><br>
		<form:input type="password" class="form-control" id="password" name="password" path="password"/><br>
		<form:errors style="color:red" path="password" /><br>
		
		<label for="confirmPassword"style="color:black;">Confirm Password:</label><br>
		<form:input type="password" class="form-control" id="confirmPassword" name="confirmPassword" path="confirmPassword" /><br>
		<form:errors style="color:red" path="confirmPassword" />
		<br>
			
		 <input type="submit" value="Submit" id="add-user">
		</div>
	</form:form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>

</html>