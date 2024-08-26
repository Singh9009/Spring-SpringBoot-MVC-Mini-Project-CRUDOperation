<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous">
      
      

<meta charset="UTF-8">
<title>Employee Report Page</title>
</head>
<body>

<h1 style="color:Blue; text-align: center;">Employee Report</h1>

<div class="container">

<c:choose>
  <c:when test="${!empty empsData}">
      <table border="1" align="center" class="table table-striped">
         <tr class="table-dark">
            <th>EmpNo</th>
            <th>EmpName</th>
            <th>Job</th>
            <th>Salary</th>
            <th>Operations</th>
         </tr>
       <c:forEach items="${empsData}" var="employee">
          <tr>
            <td>${employee.empno }</td>
             <td>${employee.ename }</td>
              <td>${employee.job }</td>
               <td>${employee.salary }</td> 
                <td><a href="edit?no=${employee.empno}">edit</a>&nbsp;&nbsp;<a href="delete?no=${employee.empno}">delete</a></td>
          </tr>
       </c:forEach>
      </table>
     </c:when>
     <c:otherwise>
        <h2 style="color:red">No Record Found</h2>
     </c:otherwise>
</c:choose>

<c:if test="${!empty resultMsg }">
     <h3 style="color: green; text-align: center;">${resultMsg}</h3>
</c:if>

<br><br>

<h2 style="text-align: center;color: aqua;"><a href="add">Add Employee</a></h2>

</div>

</body>
</html>