<%@page import="com.vwits.model.javabean.Test"%>
<%@page import="com.vwits.model.javabean.Student"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Display Questions</title>
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
	}else*/{ 

			List<Test> list = (List)request.getAttribute("list");
			/*String msg = (String)request.getAttribute("message");
			if(msg!=null)
				out.println("id = "+msg);*/
			if(list == null){
				out.println("No Record Found!!");
			}else{
				

	%>
	
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
		     <li class="nav-item active"><a class="nav-link" href="DisplayQuestion">Display Questions</a></li>
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
          
        </div>
		        <div class="col-sm-8 text-left"> 
		          
		          <table class="table">
		  <thead class="thead-dark">
		    <tr>
		      <th scope="col">ID</th>
		      <th scope="col">Question</th>
		      <th scope="col">Option A</th>
		      <th scope="col">Option B</th>
		      <th scope="col">Option C</th>
		      <th scope="col">Option D</th>
		      <th scope="col">Ans</th>
		      <th>
		      	<a href="AddQuestion.jsp" class="btn btn-info btn-sm">
          			<span class="glyphicon glyphicon-plus"></span> Add Question
        		</a>
        	 </th>
		    </tr>
		  </thead>
		  <tbody>
		    <tr>
		    <% for(int i=0; i<list.size(); i++){ %>
		      <th scope="row"><% out.println(list.get(i).getQueid()); %></th>
		      <td><% out.println(list.get(i).getQue()); %></td>
		      <td><% out.println(list.get(i).getOptionA()); %></td>
		      <td><% out.println(list.get(i).getOptionB()); %></td>
		      <td><% out.println(list.get(i).getOptionC()); %></td>
		      <td><% out.println(list.get(i).getOptionD()); %></td>
		      <td><% out.println(list.get(i).getAns()); %></td>
		      <td>
		      	<a href="deleteQue?queid=<% out.println(list.get(i).getQueid()); %>">
          			<span class="glyphicon glyphicon-trash"></span>
          		</a>&nbsp;
          		<a href="updateQue?queid=<% out.println(list.get(i).getQueid()); %>">
          			<span class="glyphicon glyphicon-pencil"></span>
        		</a>
          	  </td>
		    </tr>
		    <% }%>
		  </tbody>
		</table>
          
        </div>
        <div class="col-sm-2 sidenav"></div>
      </div>
    </div>
	 <% } 
	} %>
  </body>
 
</html>