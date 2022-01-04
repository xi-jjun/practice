<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--WEB-INF 아래에 있는 파일들은 외부에서 직접 호출을 할 수 없다.
항상 controller(servlet) 를 거쳐서 내부에서 forward 를 해야 한다.--%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<!-- 상대경로 사용, [현재 URL이 속한 계층 경로 + /save] -->
<form action="save" method="post">
    username: <input type="text" name="username" />
    age: <input type="text" name="age" />
    <button type="submit">전송</button>
</form>
</body>
</html>
