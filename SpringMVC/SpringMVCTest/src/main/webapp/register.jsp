<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register page</title>
</head>
<body>
    <form action="register" method="post">
        <h5>User registration</h5>
        <p>
            <label>name </label> <input type="text" id="usernam" name="username"
                tabindex="1">
        </p>

        <p>
            <label>password </label> <input type="text" id="password" name="password"
                tabindex="2">
        </p>

        <p>
            <label>age </label> <input type="text" id="age" name="age"
                tabindex="3">
        </p>
        <p id="buttons">
            <input id="submit" type="submit" tabindex="4" value="register">
            <input id="reset" type="reset" tabindex="5" value="reset">
        </p>
    </form>
</body>
</html>