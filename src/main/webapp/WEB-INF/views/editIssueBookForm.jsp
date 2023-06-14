<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Issue Book</title>
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
        .readonly-field {
            background-color: #F5F5F5; /* White Smoke */
            color: #333;
            border: none;
            padding: 10px;
            border-radius: 4px;
            width: 100%;
            margin-bottom: 5px;
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

    </style>
</head>
<body>
    <div class="section">
        <h1>Update Issue Book</h1>

        <form:form method="PUT" action="/issue/updateConfirm">
            <input type="hidden" name="issueBookId" value="${issueBook.issueBookId}" />

            <div class="link-boxes">
                <label for="memberId">Member ID:</label>
                <input id="memberId" name="memberId" value="${issueBook.member.memberId}" class="readonly-field" readonly="true" />
            </div>

            <div class="link-boxes">
                <label for="memberName">Member Name:</label>
                <input id="memberName" name="memberName" value="${issueBook.member.name}" class="readonly-field" readonly="true" />
            </div>

            <div class="link-boxes">
                <label for="bookId">Book:</label>
                <input id="bookId" name="bookId" value="${issueBook.book.bookId}" class="readonly-field" readonly="true" />
            </div>

            <div class="link-boxes">
                <label for="issueDate">Issue Date:</label>
                <input id="issueDate" name="issueDate" value="${issueBook.issueDate}" class="readonly-field" readonly="true" />
            </div>

            <div class="link-boxes">
                <label for="returnDate">Return Date:</label>
                <input id="returnDate" type="date" name="returnDate" class="action-button" value="${issueBook.returnDate}" />
            </div>

            <div class="link-boxes">
                <input type="submit" value="Update" class="edit-button" />
            </div>
           <a href="/webmvc/dashboard" class="cancel-button">Cancel</a>
        </form:form>


    </div>
</body>
</html>
