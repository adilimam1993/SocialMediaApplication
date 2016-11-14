<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="mediaStyle.css">
<link href="https://fonts.googleapis.com/css?family=Rationale" rel="stylesheet"> 
<title>Insert title here</title>
</head>
<body>
   
   
   
    
     <div id="profile">
            
            
            <div id="profile-img">
                                
                
                
                <img src="<%=request.getSession().getAttribute("image")%>" alt="Profile Image" width="200px" height="140px">
                
                
                             
 
<h2>  
       
       <%= request.getSession().getAttribute("fname") %>
       <%= request.getSession().getAttribute("lname") %>
     
</h2> 
 
 
 <p>   <%  %> </p>



                           
 <jsp:useBean id="users" class="beans.Users" scope="session"></jsp:useBean>
 <jsp:setProperty property="email" name="users" value=""/>
 
 <div class="stat">
 <p>Total Posts 40</p>
 <p>Total Comments 70</p>
 </div> 
     
   <div class="Update-Image">  
   
   <h3>Update Image</h3>
      
	 <form action="ProcessImage" method="post" enctype="multipart/form-data" name="uploadForm"> 	 
	 <input type="file" name="file" width="100"/>
	 <br>
	 <input type="submit" value="Post It" id="pic" />
	
	</form>
   </div>   
   
   
   
                
 </div>
            
    
  
          
 <div class="logout">
 <input type="button" value="Log Out" onclick="location.href = 'index.html';">      
 </div>         
          
</div>

</body>
</html>