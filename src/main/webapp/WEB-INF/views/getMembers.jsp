<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Members</title>
    <style>
        /* Add your custom CSS styles here */
        body {
            font-family: Arial, sans-serif;
            background-color: #778899; /* Thick Gray */
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .section {
            background-color: #778899;
            padding: 20px;
            border-radius: 5px;
            text-align: center;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            width: 350px; /* Increased width */
            color: #fff;
        }

        .member {
            margin-bottom: 10px;
            padding: 10px;
            border-radius: 4px;
            background-color: #F5F5F5; /* White Smoke */
            color: #333;
        }

        .cancel-button {
            display: block;
            background-color: #F5F5F5; /* White Smoke */
            color: #333;
            border: none;
            padding: 10px;
            border-radius: 4px;
            cursor: pointer;
            margin-bottom: 10px;
            width: 100%;
            transition: background-color 0.3s;
            text-decoration: none;
        }

        .cancel-button:hover {
            background-color: #E8E8E8;
        }
    </style>
</head>
<body>
    <div class="section">
        <h1>All Members</h1>

        <c:forEach items="${members}" var="member">
            <div class="member">
                <h3>${member.name}</h3>
                <p>Member Id: ${member.memberId}</p>
                <p>Address: ${member.addresses[0].location}</p>
                <p>Phone Number: ${member.addresses[0].phoneNumber}</p>
            </div>
        </c:forEach>

                <a href="/webmvc/dashboard" class="cancel-button">Go Back</a>
    </div>
</body>
</html>
