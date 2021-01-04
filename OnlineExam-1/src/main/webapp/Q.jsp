<%@page import="com.vwits.model.javabean.Test"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Test</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script>
	function hello(){
		alert("hello");
	}
  </script>
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
	  <%
	  	/*session = request.getSession(false);
		String studentid = (String)session.getAttribute("studentid");
		out.println(studentid);
		
		if(studentid == null){
			out.println("Session Invalid");
		}else */{ 
			Test list = (Test)request.getAttribute("list");
			String message = (String)request.getAttribute("message");
			if(list == null){
				out.println("No Record Found!!");
			}else{
				session = request.getSession(true);
				session.setAttribute("queid", list.getQueid());
	%>
      
    <div class="container-fluid text-center">    
      <div class="row content">
    	<div class="col-sm-2 sidenav"></div>
          <div class="col-sm-8 text-left">   
            <div>
				<form action="OneQuestion" method="post">
					<h5><%=list.getQueid()%>
						&nbsp;&nbsp;
						<%=list.getQue()%>
					</h5>
					<hr>
					<div class="custom-control custom-radio">
						<input type="radio" id="radio" name="ans" value="<%=list.getOptionA()%>" class="custom-control-input"> 
						<label class="custom-control-label" for="ans"><%=list.getOptionA()%></label>
					</div>
					<br>
					<div class="custom-control custom-radio">
						<input type="radio" id="radio" name="ans" value="<%=list.getOptionB()%>" class="custom-control-input"> 
						<label class="custom-control-label" for="ans"><%=list.getOptionB()%></label>
					</div>
					<br>
					<div class="custom-control custom-radio">
						<input type="radio" id="radio" name="ans" value="<%=list.getOptionC()%>" class="custom-control-input"> 
						<label class="custom-control-label" for="ans"><%=list.getOptionC()%></label>
					</div>
					<br>
					<div class="custom-control custom-radio">
						<input type="radio" id="radio" name="ans" value="<%=list.getOptionD()%>" class="custom-control-input"> 
						<label class="custom-control-label" for="ans"><%=list.getOptionD()%></label>
					</div>
					<br>
					<hr>
					<% if(message != null) {
						if(message.equalsIgnoreCase("disable prev")) { %>
							<button type="submit" onclick="prev()" class="btn btn-outline-secondary" disabled name="submit" value="prev">Previous</button>
						<% } else { %>
							<button type="submit" onclick="prev()" class="btn btn-outline-secondary" name="submit" value="prev">Previous</button>
						<% } if(message.equalsIgnoreCase("disable next")) { %>
							<button type="submit" onclick="next()" class="btn btn-outline-secondary" disabled name="submit" value="next">Next</button>
							<button type="submit" class="btn btn-primary" name="submit" value="submit">Submit</button>
						<% } else { %>
							<button type="submit" class="btn btn-outline-secondary" name="submit" value="next">Next</button>
						<% }
					} else { %>
					<button type="submit" class="btn btn-outline-secondary" disabled name="submit" value="prev">Previous</button>
					<button type="submit" onclick="next()" class="btn btn-outline-secondary" name="submit" value="next">Next</button>
					<% } %>
				</form>	
				<hr>
				<form action="exitTest" method="post">
					<button type="submit" class="btn btn-primary" name="exit" value="exit">Exit Test</button>
				</form>
		    </div>
          </div>
        <div class="col-sm-2 sidenav"></div>
      </div>
    </div>
	 <% } %>
		<% }%>	
  </body>
 	
</html>