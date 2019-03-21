<%--
  Created by IntelliJ IDEA.
  User: deeplove
  Date: 2019/3/19
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加页面</title>
</head>
<body>

    <form action="/emp/insert" method="post">
        <p>
            用户编号：<input name="empId" type="text"/>
        </p>
        <p>
            用户姓名：<input name="empName" type="text"/>
        </p>
        <p>
            用户性别：<input name="empGender" type="text"/>
        </p>
        <p>
            用户邮箱：<input name="email" type="text"/>
        </p>
        <p>
            所在部门：<input name="department" type="text"/>
        </p>

        <a href="/emp/main">
            <input type="button" value="返回主界面"/>
        </a>

        <input id="btnAdd" type="submit" value="保存"/>

    </form>


</body>
</html>
