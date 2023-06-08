<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Members Management</title>
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
        <h1>Members</h1>

        <form:form action="/members/add">
            <div class="link-boxes">
                <label for="name">Name</label>
                <input id="name" type="text" name="name" class="action-button" />
            </div>

            <div class="link-boxes">
                <label for="address">Address</label>
                <select id="address" name="address" class="action-button">
                    <option value="address1">Address 1</option>
                    <option value="address2">Address 2</option>
                    <option value="address3">Address 3</option>
                </select>
            </div>

            <div class="link-boxes">
                <label for="phoneNumber">Phone Number</label>
                <input id="phoneNumber" type="text" name="phoneNumber" class="action-button" />
            </div>

            <input type="submit" value="Add" class="action-button" />
        </form:form>

        <div class="link-boxes">
            <form:form action="/members/edit">
                <input type="submit" value="Edit" class="action-button" />
            </form:form>

            <form:form action="/members/delete">
                <input type="submit" value="Delete" class="action-button" />
            </form:form>
        </div>

        <form:form action="/admin/cancel">
            <input type="submit" value="Cancel" class="cancel-button" />
        </form:form>
    </div>
</body>
</html>
