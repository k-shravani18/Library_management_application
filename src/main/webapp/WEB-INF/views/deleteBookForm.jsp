<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Book</title>
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

        .delete-button {
            display: block;
            background-color: #FF0000; /* Red */
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

        .delete-button:hover {
            background-color: #CC0000;
        }

        .readonly-field {
            background-color: #F5F5F5; /* White Smoke */
            color: #333;
            border: none;
            padding: 10px;
            border-radius: 4px;
            width: 100%;
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
    <div class="section">
        <h1>Delete Book</h1>

        <form:form method="POST" action="/book/deleteBook">
            <input type="hidden" name="_method" value="DELETE" />
            <input type="hidden" name="bookId" value="${book.bookId}" />

            <div class="link-boxes">
                <label for="bookName">Book Name</label>
                <input id="bookName" type="text" name="bookName" value="${book.bookName}" class="readonly-field" readonly="true" />
            </div>

            <div class="link-boxes">
                <label for="edition">Book Edition</label>
                <input id="edition" type="text" name="edition" value="${book.edition}" class="readonly-field" readonly="true" />
            </div>

            <div class="link-boxes">
                <label for="noOfPages">No of Pages</label>
                <input id="noOfPages" type="text" name="noOfPages" value="${book.noOfPages}" class="readonly-field" readonly="true" />
            </div>

            <input type="submit" value="Confirm Delete Member" class="delete-button" />
            <a href="/webmvc/dashboard" class="cancel-button">Cancel</a>
        </form:form>
    </div>
</body>
</html>
