<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Registration</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h3>Student Registration Form</h3>
        <form action="StudentRegistration" method="post">
            <div class="form-group">
              <label for="sname">Name</label>
              <input type="text" class="form-control" name="sname" id="sname">
            </div>

            <div class="form-group">
              <label for="susername">Username</label>
              <input type="text" class="form-control" name="susername" id="susername">
            </div>

            <div class="form-group">
                <label for="spassword">Password</label>
                <input type="password" class="form-control" name="spassword" id="spassword">
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