<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body style="font-size:50px">
   <div style="height:100vh; width:100vw; display:flex; flex-direction:row;
               justify-content:center; align-items:center; background-color:khaki; ">
<!-- method : 1 to call values  -->
    <%
       Object user = request.getAttribute("user");
    %>
    <%=user%><br><br><!-- calling toString method of user class -->
    
<!-- method : 2 to call values  -->
    Hello , ${user.getUname()}
    
<!-- method : 2 to call ModelAttribute  -->
    I am ${name}
    </div>
</body>
</html>