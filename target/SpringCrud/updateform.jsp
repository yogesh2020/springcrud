<%--
  Created by IntelliJ IDEA.
  User: yogesh
  Date: 14/11/19
  Time: 12:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<form action="update" method="post">

    <div style="margin:auto;width:80%">

        <div class = "row">
            <div class = "col-sm-2">
                Username:
            </div>
            <div class = "col-sm-6">
                <input type="text" name="username" required>
            </div>
        </div>

        <div class = "row">
            <div class = "col-sm-2">
                Address:
            </div>
            <div class = "col-sm-8">
                <input type="text" name="address" required>
            </div>
        </div>

        <div class = "row">
            <div class = "col-sm-2">
                Phone:
            </div>
            <div class = "col-sm-8">
                <input type="text" name="phone" required>
            </div>
        </div>


        <div class = "row">
            <div class = "col-sm-2">
                <button type="submit" name = "button" value="updatedata">Update</button>
            </div>
        </div>

    </div>
</form>
</body>
</html>
