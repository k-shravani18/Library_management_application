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

        <form:form action="${pageContext.request.contextPath}/category/category_form" method="get" id="categoryForm">
                    <button type="submit" class="action-button">Category</button>
                </form:form>


                <form:form action="${pageContext.request.contextPath}/author/author_form" method="get" id="authorForm">
                    <button type="submit" class="action-button">Author</button>
                </form:form>


                <form:form action="${pageContext.request.contextPath}/publisher/publisher_form" method="get" id="publisherForm">
                    <button type="submit" class="action-button">Publisher</button>
                </form:form>

                <form:form action="${pageContext.request.contextPath}/webc/book" method="get" id="bookForm">
                    <button type="submit" class="action-button">Book</button>
                </form:form>

                <form:form action="${pageContext.request.contextPath}/webc/member" method="get" id="memberForm">
                    <button type="submit" class="action-button">Member</button>
                </form:form>

                <form:form action="${pageContext.request.contextPath}/webc/issueBook" method="get" id="issueBookForm">
                    <button type="submit" class="action-button">Issue Book</button>
                </form:form>

                <form:form action="${pageContext.request.contextPath}/webc/returnbook" method="get" id="returnBookForm">
                    <button type="submit" class="action-button">Return Book</button>
                </form:form>

                <form:form action="${pageContext.request.contextPath}/webc/logout" method="get" id="logoutForm">
                    <button type="submit" class="action-button">Logout</button>
                </form:form>


                <script>
                    function submitForm(formId) {
                        document.getElementById(formId).submit();
                    }
                </script>
            </div>
        </body>
        </html>