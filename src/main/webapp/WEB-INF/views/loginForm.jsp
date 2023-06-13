<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        /* Add your custom CSS styles here */
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .login-container {
            background-color: #f5f5f5;
            padding: 20px;
            border-radius: 5px;
        }

        .header {
            text-align: center;
            margin-bottom: 20px;
        }

        h1 {
            color: #333;
            margin: 0;
        }

        .form-container {
            max-width: 400px;
            margin: 0 auto;
        }

        .form-group {
            margin-bottom: 10px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            font-size: 14px;
        }

        .submit-button {
            display: block;
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 10px;
            transition: background-color 0.3s;
        }

        .submit-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <div class="header">
            <h1>Login</h1>
        </div>
        <div class="form-container">
            <form:form action="/auth-api/processLogin" modelAttribute="loginForm" method="post">
                <div class="form-group">
                    <label for="username">Username</label>
                    <form:input path="username" id="username" />
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <form:input path="password" id="password" type="password" />
                </div>
                <input type="submit" value="Login" class="submit-button" />
            </form:form>
        </div>
    </div>
</body>
</html>
