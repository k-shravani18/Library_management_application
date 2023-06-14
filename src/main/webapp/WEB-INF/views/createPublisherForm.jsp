<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Publisher Management</title>
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
        .separator {
            height: 4px;
            width: 106%;
            background-color: #fff;
            margin-top: 20px;
            margin-bottom: 15px;
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
        <h1>Publisher</h1>

        <form:form action="/publisher/add_publisher" modelAttribute="publisher">
            <div class="link-boxes" style="flex-direction:column">
                <label for="name">Name</label>
                <input id="name" type="text" name="name" class="action-button" />

                <label for="addressList[0].location">Address</label>
                    <input id="addressList[0].location" type="text" name="addressList[0].location" class="action-button" placeholder="Enter Location" required />

                    <label for="addressList[0].phoneNumber">Phone Number</label>
                    <input id="addressList[0].phoneNumber" type="text" name="addressList[0].phoneNumber" class="action-button" placeholder="Enter Phone number" required />

                    <div class="link-boxes">
                        <input type="submit" value="Add" class="action-button" />
                    </div>
        </form:form>

                     <div class="separator"></div>
                        <div><h3>Edit Publisher</h3></div>
                        <form:form method="GET" action="/publisher/editPublisher">
                            <div class="link-boxes">
                                <label for="publisherId">Publisher ID</label>
                                <input id="publisherId" type="text" name="publisherId" class="action-button" placeholder="Enter Valid publisher ID" required/>
                            </div>

                            <input type="submit" value="Edit Publisher" class="action-button" />
                        </form:form>

                     <div class="separator"></div>
                        <div><h3>Delete Publisher</h3></div>
                                <div>
                                 <form method="GET" action="/publisher/delete">
                                    <div class="link-boxes">
                                        <label for="publisherId">Publisher ID</label>
                                        <input id="publisherId" type="text" name="publisherId" class="action-button" placeholder="Enter Valid Publisher ID" />
                                    </div>
                                 <input type="submit" value="Delete Publisher" class="action-button" />
                               </form>
                         </div>

                    <div class="separator"></div>
                    <div><h3>Show All Publishers</h3></div>
                        <div>
                            <form method="GET" action="/publisher/allPublishers">
                                <input type="submit" value="Show All Publishers" class="action-button" />
                            </form>
                        </div>

                    <div class="separator"></div>
                <a href="/webc/dashboard" class="cancel-button">Cancel</a>
            </div>

</body>
</html>
