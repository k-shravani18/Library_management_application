<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Management</title>
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
        <h1>Book</h1>

        <form:form action="/book/add">
            <div class="link-boxes">
                <label for="bookName">Book Name</label>
                <input id="bookName" type="text" name="bookName" class="action-button" />
            </div>

            <div class="link-boxes">
                <label for="category">Category</label>
                <select id="category" name="category" class="action-button">
                    <option value="category1">Category 1</option>
                    <option value="category2">Category 2</option>
                    <option value="category3">Category 3</option>
                </select>
            </div>

            <div class="link-boxes">
                <label for="author">Author</label>
                <input id="author" type="text" name="author" class="action-button" />
            </div>

            <div class="link-boxes">
                <label for="publisher">Publisher</label>
                <select id="publisher" name="publisher" class="action-button">
                    <option value="publisher1">Publisher 1</option>
                    <option value="publisher2">Publisher 2</option>
                    <option value="publisher3">Publisher 3</option>
                </select>
            </div>

            <div class="link-boxes">
                <label for="pages">Number of Pages</label>
                <input id="pages" type="number" name="pages" class="action-button" />
            </div>

            <div class="link-boxes">
                <label for="edition">Edition</label>
                <input id="edition" type="text" name="edition" class="action-button" />
            </div>

            <input type="submit" value="Add" class="action-button" />
        </form:form>

        <form:form action="/book/edit">
            <input type="submit" value="Edit" class="action-button" />
        </form:form>

        <form:form action="/book/delete">
            <input type="submit" value="Delete" class="action-button" />
        </form:form>

        <form:form action="/admin/cancel" style="display: flex; justify-content: center;">
            <input type="submit" value="Cancel" class="cancel-button" style="width: 130px;" />
        </form:form>
    </div>
</body>
</html>
