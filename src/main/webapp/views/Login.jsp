<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
  <!-- used for RequestMapping -->
  <!--<form action="addUser">
  Enter id : <input type="text" name="uid"><br><br>
  Enter name : <input type="text" name="uname"><br><br>
  <input type="submit" value="submit">
  </form>-->
  
  <!-- used for PostMapping -->
  <!--<form action="addUser" method="post">
  Enter id : <input type="text" name="uid"><br><br>
  Enter name : <input type="text" name="uname"><br><br>
  <input type="submit" value="submit">
  </form>-->
  
  <!-- Hibernate practice -->
  <form action="addUser" method="post">
  Enter id : <input type="text" name="uid"><br><br>
  Enter name : <input type="text" name="uname"><br><br>
  <input type="submit" value="submit">
  </form>
  
 
  <form action="getuser" method="post">
  Enter id of User : <input type="text" name="uid">
  <input type="submit" value="submit">
  </form>
  <hr><br>
  <form action="updateUser" method="post">
  Enter id of User to update : <input type="text" name="uid"><br>
  Enter updated name : <input type="text" name="uname"><br><br>
  <input type="submit" value="submit">
  </form>
  
  <hr><br>
  <form action="delete" method="post">
  Enter id of User to Remove from Database : <input type="text" name="uid"><br>
  <input type="submit" value="submit">
  </form>
  
  <hr><br>
  <form action="FindByName" method="post">
  Enter name of User to get data : <input type="text" name="uname"><br>
  <input type="submit" value="submit">
  </form>
  
</body>
</html>