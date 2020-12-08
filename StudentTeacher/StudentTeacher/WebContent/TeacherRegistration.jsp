<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<html lang="en">
<head>
  <title>Teacher Registration Form</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
  <body>
	
	
    <nav class="navbar navbar-inverse">
      
    </nav>
      
    <div class="container-fluid text-center">    
      <div class="row content">
        <div class="col-sm-2 sidenav">
          
        </div>
        <div class="col-sm-8 text-left"> 
          
         <div class="container">
		<h3>Teacher Registration Form</h3>
        <form action="TeacherRegistration" method="post">
            <div class="form-group">
              <label for="tname">Name</label>
              <input type="text" class="form-control" placeholder="Enter Name" required name="tname" id="tname">
            </div>

            <div class="form-group">
              <label for="tusername">Username</label>
              <input type="text" class="form-control" placeholder="Enter Username"  required name="tusername" id="tusername">
            </div>

            <div class="form-group">
                <label for="tpassword">Password</label>
                <input type="password" class="form-control" placeholder="Enter Password"  required name="tpassword" id="tpassword">
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
          </form>
    </div>
         
        </div>
        <div class="col-sm-2 sidenav">
          
        </div>
      </div>
    </div>

    <footer class="container-fluid text-center">
      
    </footer>
	   <%
		String message = (String)request.getAttribute("message");
		if(message != null)                		
			out.println(message);
	%>
	   
	
  </body>
 
</html>