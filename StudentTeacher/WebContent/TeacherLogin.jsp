<%@ page language="java" session="true" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teacher Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h3>Teacher Login Form</h3>
        <form action="TeacherLogin" method="post">

            <div class="form-group">
              <label for="tusername">Username</label>
              <input type="text" class="form-control" name="tusername" id="tusername">
            </div>

            <div class="form-group">
                <label for="tpassword">Password</label>
                <input type="password" class="form-control" name="tpassword" id="tpassword">
            </div>

            <button type="submit" class="btn btn-primary" name="submit" value="login">Login</button><br><hr>
            <button type="submit" class="btn btn-primary" name="submit" value="register">Register</button>
          </form>
          
    </div>
    <%
		String message = (String)request.getAttribute("message");
		if(message != null){
			if(message.equals("Login Successfull!!")){
				out.println(message);
			}
			else {
				out.println(message);
			}
		}		
	%>
</body>
</html>