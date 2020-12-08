<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teacher Registration</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h3>Teacher Registration Form</h3>
        <form action="TeacherRegistration" method="post">
            <div class="form-group">
              <label for="tname">Name</label>
              <input type="text" class="form-control" required name="tname" id="tname">
            </div>

            <div class="form-group">
              <label for="tusername">Username</label>
              <input type="text" class="form-control" required name="tusername" id="tusername">
            </div>

            <div class="form-group">
                <label for="tpassword">Password</label>
                <input type="password" class="form-control" required name="tpassword" id="tpassword">
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
          </form>
    </div>
    <%
		String message = (String)request.getAttribute("message");
		if(message != null)                		
			out.println(message);
	%>
</body>
</html>