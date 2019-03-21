<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: deeplove
  Date: 2019/3/19
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有员工信息</title>
    <style>
        tr{
            height:10px;
        }
        td,th{
            width:80px;
        }
    </style>
</head>
<body>

<p>
    <a href="/emp/goto/insert">添加新员工</a>
</p> <br/><br/>

    <table style="text-align: center;" cellpadding="0" cellspacing="0" border="1" align="center">
        <tr>
                <th>员工编号</th>
                <th>员工姓名</th>
                <th>员工性别</th>
                <th>员工邮箱</th>
                <th>所在部门</th>
                <th>操作</th>
        </tr>

        <c:forEach items="${emps}" var="item">
            <tr>
                <td>${item.empId}</td>
                <td>${item.empName}</td>
                <td>${item.empGender}</td>
                <td>${item.email}</td>
                <td>${item.department}</td>
                <td>
                    <a href="/emp/updateByPrimaryId/${item.empId}">修改</a>
                    <a href="/emp/deleteByPrimaryKey/${item.empId}">删除</a>
                </td>
            </tr>
        </c:forEach>

    </table>


    <p>
        <c:forEach begin="0" end="${page.pages}" var="i">
            <a href="/emp/main/${i+1}">${i+1}</a>
        </c:forEach>
    </p>


</body>
</html>
