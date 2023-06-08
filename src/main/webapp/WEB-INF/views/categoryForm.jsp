<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Category Management</title>
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
        text-align:start;
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
                margin-bottom: 2px
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
        <h1>Category</h1>

        <form:form action="${pageContext.request.contextPath}/webc/category/add">

            <div class="link-boxes" style="flex-direction:column">
            <label for ="category"> Category</label>
                <input id="category"type="text" name="category" class="action-button" />
            </div>
        </form:form>

        <div class="link-boxes">
             <form:form action="/${pageContext.request.contextPath}category/add">
                <input type="submit" value="Add" class="action-button" />
            </form:form>
            <form:form action="${pageContext.request.contextPath}/category/edit">
                <input type="submit" value="Edit" class="action-button" />
            </form:form>

            <form:form action="/category/delete">
                <input type="submit" value="Delete" class="action-button" />
            </form:form>
        </div>

        <form:form action="/category/cancel" style="
                                              display: flex;
                                              justify-content: center;
                                          ">
            <input type="submit" value="Cancel" class="cancel-button" style="width: 130px;" />
        </form:form>
    </div>
</body>
</html>
