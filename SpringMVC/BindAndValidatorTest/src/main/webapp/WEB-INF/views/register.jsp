<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register page</title>
</head>
<body>
    <div id="global">
        <form:form modelAttribute="user" method="post" action="register">
            <fieldset>
                <legend>register</legend>
                <p>
                    <label>name:</label>
                    <form:input path="username" />
                    <form:errors path="username" cssStyle="color:red"/>
                </p>
                <p>
                    <label>password:</label>
                    <form:password path="password" />
                    <form:errors path="password" cssStyle="color:red"/>
                </p>
                <p>
                    <label>age:</label>
                    <form:input path="age" />
                    <form:errors path="age" cssStyle="color:red"/>
                </p>
                <p>
                    <label>phone:</label>
                    <form:input path="phone" />
                    <form:errors path="phone" cssStyle="color:red"/>
                </p>
                <p>
                    <label>email:</label>
                    <form:input path="email" />
                    <form:errors path="email" cssStyle="color:red"/>
                </p>
                <p id="buttons">
                    <input id="submit" type="submit" value="register"> <input
                        id="reset" type="reset" value="reset">
                </p>
            </fieldset>
        </form:form>
    </div>
</body>
</html>