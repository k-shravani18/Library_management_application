<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
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

        .section {
            background-color: #778899;
            padding: 20px;
            border-radius: 5px;
            text-align: center;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            width: 200px; /* Increased width */
        }

        .action-button {
            display: block;
            background-color: whitesmoke; /* White Smoke */
            color: #333333; /* Text color */
            border: none;
            padding: 10px;
            border-radius: 4px;
            cursor: pointer;
            margin-bottom: 10px;
            width: 100%;
            transition: background-color 0.3s;
            text-decoration: none;
        }

        .action-button:hover {
            background-color: #F0F8FF;
        }

        .section .action-button {
            margin-bottom: 15px; /* Increased gap between buttons */
        }

        .dashboard-title {
            margin-top: 0; /* Removed default margin */
            margin-bottom: 20px; /* Added margin-bottom */
        }
    </style>
</head>
<body>
    <div class="section">
        <h1 class="dashboard-title">Admin Dashboard</h1>

        <form:form action="${pageContext.request.contextPath}/webc/category" id="categoryForm">
            <input type="submit" value="Category" class="action-button" onclick="submitForm('categoryForm')" />
        </form:form>

        <form:form action="${pageContext.request.contextPath}/webc/author" id="authorForm">
            <input type="submit" value="Author" class="action-button" onclick="submitForm('authorForm')" />
        </form:form>

        <form:form action="/webc/publisher" id="publisherForm">
            <input type="submit" value="Publisher" class="action-button" onclick="submitForm('publisherForm')" />
        </form:form>

        <form:form action="/webc/book" id="bookForm">
            <input type="submit" value="Book" class="action-button" onclick="submitForm('bookForm')" />
        </form:form>

        <form:form action="/webc/member" id="memberForm">
            <input type="submit" value="Member" class="action-button" onclick="submitForm('memberForm')" />
        </form:form>

        <form:form action="/webc/issue-book" id="issueBookForm">
            <input type="submit" value="Issue Book" class="action-button" onclick="submitForm('issueBookForm')" />
        </form:form>

        <form:form action="/webc/return-book" id="returnBookForm">
            <input type="submit" value="Return Book" class="action-button" onclick="submitForm('returnBookForm')" />
        </form:form>

        <form:form action="/webc/logout" id="logoutForm">
            <input type="submit" value="Logout" class="action-button" onclick="submitForm('logoutForm')" />
        </form:form>

        <script>
            function submitForm(formId) {
                document.getElementById(formId).submit();
            }
        </script>
    </div>
</body>
</html>
