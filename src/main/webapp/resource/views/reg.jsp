<%--
  Created by IntelliJ IDEA.
  User: lanou
  Date: 2017/12/2
  Time: 下午5:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"
            +request.getServerName()+":"
            +request.getServerPort()+path+"/";
%>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=basePath%>/user/addUser.do" method="post">
    <input type="text" name="userName">
    <input type="text" name="password">
    <input type="submit" value="注册">

</form>
</body>
</html>
