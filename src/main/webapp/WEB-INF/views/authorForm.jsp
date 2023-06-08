<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Author Management</title>
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
            justify-content: space-between;
            margin-bottom: 50px;
        }

        .action-button {
            display: inline-block;
            background-color: #F5F5F5; /* White Smoke */
            color: #333;
            border: none;
            padding: 10px 30px 10px 30px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
            text-decoration: none;
            width: -webkit-fill-available;
            margin-bottom: 10px;
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

        .logout-button {
            display: block;
            background-color: #F5F5F5; /* White Smoke */
            color: #333;
            border: none;
            padding: 10px;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 20px; /* Added margin-top for positioning */
            width: 100%;
            transition: background-color 0.3s;
            text-decoration: none;
        }

        .logout-button:hover {
            background-color: #E8E8E8;
        }
    </style>
</head>
<body>
    <div class="section">
        <h1>Author Management</h1>

        <form:form action="/author/add" method="post">
            <div class="link-boxes" style="flex-direction: column">
                <label for="name">Name</label>
                <input id="name" type="text" name="name" class="action-button" />
                <label for="country">Country</label>
                <select id="country" name="country" class="action-button">
                    <option value="USA">USA</option>
                    <option value="UK">UK</option>
                    <option value="Canada">Canada</option>
                    <!-- Add more options as needed -->
                </select>
            </div>

            <div class="link-boxes">
                <input type="submit" value="Add" class="action-button" />
                <input type="submit" value="Edit" class="action-button" />
                <input type="submit" value="Delete" class="action-button" />
            </div>
        </form:form>

        <form:form action="/admin/cancel" method="post" style="display: flex; justify-content: center;">
            <input type="submit" value="Cancel" class="cancel-button" style="width: 130px;" />
        </form:form>
    </div>
</body>
</html>
