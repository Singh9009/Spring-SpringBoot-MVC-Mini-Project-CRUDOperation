<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Employee Page</title>
</head>
<body>

<form:form modelAttribute="employee">
   <table border="1" align="center">
    <tr>
        <td>Employee No</td>
        <td><form:input path="empno" readonly="true"/></td>
     </tr>
   
     <tr>
        <td>Employee Name</td>
        <td><form:input path="ename"/></td>
     </tr>
     
     <tr>
        <td>Employee Designation</td>
        <td><form:input path="job"/></td>
     </tr>
     
     <tr>
        <td>Employee Salary</td>
        <td><form:input path="salary"/></td>
     </tr>
     
     <tr>
        <td colspan="2" align="center"><input type="submit" value="Edit Employee"/></td>
     </tr>
   </table>
</form:form>

</body>
</html>