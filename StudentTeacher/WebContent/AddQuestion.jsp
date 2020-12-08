<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Question</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h3>Add Question</h3>
        <form action="AddQuestion" method="post">
        	<div class="form-group">
              <label for="optionA">Enter Question</label>
              <input type="text" class="form-control" name="que" required id="que">
            </div>
            
            <div class="form-group">
              <label for="optionA">Enter Option A</label>
              <input type="text" class="form-control" name="optionA" required id="optionA">
            </div>

            <div class="form-group">
                <label for="optionB">Enter Option B</label>
                <input type="text" class="form-control" name="optionB" required id="optionB">
            </div>
            
            <div class="form-group">
                <label for="optionC">Enter Option C</label>
                <input type="text" class="form-control" name="optionC" required id="optionC">
            </div>
            
            <div class="form-group">
                <label for="optionD">Enter Option D</label>
                <input type="text" class="form-control" name="optionD" required id="optionD">
            </div>
            
            <div class="form-group">
                <label for="ans">Enter Answer</label>
                <input type="text" class="form-control" name="ans" required id="ans">
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
          </form>
    </div>
    <%
		String message = (String)request.getAttribute("message");
		if(message != null)      
			if(message.equals("Question Added Successfully!!")){ %>
				<div class="alert alert-primary" role="alert">
				  <h5>Question Added Successfully!!</h5>
				</div>
			<% } else{ %>
				<div class="alert alert-danger" role="alert">
  					<h5>Problem in Inserting Question</h5>
				</div>
		<% }
			
	%>
</body>
</html>