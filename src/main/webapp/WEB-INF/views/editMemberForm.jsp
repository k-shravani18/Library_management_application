<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Member</title>
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
            height: 100vh;
        }

        label {
            margin: 5px;
            text-align: start;
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

        .link-boxes {
            display: flex;
            flex-direction: column;
            margin-bottom: 20px;
        }

        .action-button {
            display: block;
            background-color: #F5F5F5; /* White Smoke */
            color: #333;
            border: none;
            padding: 10px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
            text-decoration: none;
            width: 100%;
            margin-bottom: 5px;
        }

        .action-button:last-child {
            margin-right: 0; /* Remove margin-right for the last button */
        }

        .action-button:hover {
            background-color: #E8E8E8;
        }
        .edit-button {
            display: block;
            background-color: #00FF00; /* Green */
            color: #fff;
            border: none;
            padding: 10px;
            margin-left: 5px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
            text-decoration: none;
            width: 100%;
            margin-bottom: 5px;
        }

        .edit-button:hover {
            background-color: #009900;
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
        <h1>Edit Member</h1>

        <form:form method="PUT" action="/member/updateMember">
            <input type="hidden" name="memberId" value="${member.memberId}" />

            <div class="link-boxes">
                <label for="name">Name</label>
                <input id="name" type="text" name="name" value="${member.name}" class="action-button" required/>
            </div>

            <div class="link-boxes">
                <label for="location">Address</label>
                <input id="location" type="text" name="location" value="${member.addresses[0].location}" class="action-button" required />
            </div>

            <div class="link-boxes">
                <label for="phoneNumber">Phone Number</label>
                <input id="phoneNumber" type="text" name="phoneNumber" value="${member.addresses[0].phoneNumber}" class="action-button" required/>
            </div>

            <input type="submit" value="Update" class="edit-button" />
            <a href="/webmvc/dashboard" class="cancel-button">Cancel</a>
        </form:form>
    </div>
</body>
</html>
