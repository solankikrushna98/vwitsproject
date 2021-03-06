<%@page import="com.vwits.model.javabean.Test"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Update Test</title>
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
	<%/*
	session = request.getSession(false);
	String username = (String)session.getAttribute("username");
	if(username == null){
		out.println("Session Invalid");
	}else*/{ %>
	
    <nav class="navbar navbar-inverse">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>                        
          </button>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
          <ul class="nav navbar-nav">
             <li class="nav-item"><a class="nav-link" href="TeacherHomepage.jsp">Home</a></li>
		     <li class="nav-item"><a class="nav-link" href="DisplayResult">Display Results</a></li>
		     <li class="nav-item"><a class="nav-link" href="DisplayQuestion">Display Questions</a></li>
		     <li class="nav-item"><a class="nav-link" href="UpdateTeacherProfile.jsp">Update Profile</a></li>   	  
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="LogoutTeacher"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
          </ul>
        </div>
      </div>
    </nav>
      
    <div class="container-fluid text-center">    
      <div class="row content">
        <div class="col-sm-2 sidenav">
      <%}
        String message = (String)request.getAttribute("message");     
        List<Test> list = (List)request.getAttribute("list");
      	if(message != null){
        out.println(message);
      }
      %>
        </div>
        <div class="col-sm-8 text-left"> 
          
             <div class="container">
        <h3>Update Test</h3>
          
          <form action="UpdateTest?queid=<%=list.get(0).getQueid()%>&que=<%=list.get(0).getQue() %>" method="post">
        		<hr>
                <label for="queid">
                	<%=list.get(0).getQueid()%>&nbsp;&nbsp;
                	<%=list.get(0).getQue()%>
                </label>
                <hr>
              <div class="form-group">
                <label for="optionA">Edit Option A</label>
                <input type="text" class="form-control" placeholder="<%=list.get(0).getOptionA()%>" name="optionA" required id="optionA">
              </div>
  
              <div class="form-group">
                  <label for="optionB">Edit Option B</label>
                  <input type="text" class="form-control" placeholder="<%=list.get(0).getOptionB()%>" name="optionB" required id="optionB">
              </div>
              
              <div class="form-group">
                  <label for="optionC">Edit Option C</label>
                  <input type="text" class="form-control" placeholder="<%=list.get(0).getOptionC()%>" name="optionC" required id="optionC">
              </div>
              
              <div class="form-group">
                  <label for="optionD">Edit Option D</label>
                  <input type="text" class="form-control" placeholder="<%=list.get(0).getOptionD()%>" name="optionD" required id="optionD">
              </div>
              
              <div class="form-group">
                  <label for="ans">Edit Answer</label>
                  <input type="text" class="form-control" placeholder="<%=list.get(0).getAns()%>" name="ans" required id="ans">
              </div>
  
              <button type="submit" class="btn btn-primary">Submit</button>
            </form>
      </div> 
       
        <div class="col-sm-2 sidenav">
          
        </div>
      </div>
    </div>

	  
  </body>
 
</html>