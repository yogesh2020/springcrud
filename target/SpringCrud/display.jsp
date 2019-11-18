<!DOCTYPE html>
<%@page import="com.decipher.Model.Employee"%>
<%@page import="java.util.List"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
    </style>
</head>

<body align="center"></body>

</head>
<body>

<table>
    <tr>
        <th>Roll No</th>
        <th>Username</th>
        <th>Address</th>
        <th>Phone</th>
    </tr>

    <%
        List<Employee> emplist = (List<Employee>) session.getAttribute("employeeList");
        for(Employee empp: emplist) {

    %>
    <tr>
         <td> <%=empp.getRollNumber()%></td>
        <td> <%=empp.getUserName()%></td>
        <td><%=empp.getAddress()%> </td>
        <td><%=empp.getPhone()%></td>
    </tr>
    <%
        }
    %>


</table>
<br>
<button onclick="location='./index.jsp'">HomePage</button>
</body>
</html>