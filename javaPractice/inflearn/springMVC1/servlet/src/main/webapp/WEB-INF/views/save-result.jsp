<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공!
<ul>
<%--    아래 표현은 너무 복잡하다 JSP가 제공하는 표현식을 쓰자--%>
<%--    <li>id=<%=((Member)request.getAttribute("member")).getId()%></li>--%>
<%--    <li>username=<%=((Member)request.getAttribute("member")).getUsername()%></li>--%>
<%--    <li>age=<%=((Member)request.getAttribute("member")).getAge()%></li>--%>
    <li>id=${member.id}</li>
    <li>username=${member.username}</li>
    <li>age=${member.age}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
