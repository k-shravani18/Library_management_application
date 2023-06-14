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
        .separator {
                    height: 4px;
                    width: 106%;
                    background-color: #fff;
                    margin-top: 20px;
                    margin-bottom: 15px;
                }

        .cancel-button:hover {
            background-color: #E8E8E8;
        }
        input:invalid {
            border-color: red;
        }

        input:invalid:focus {
            outline-color: red;
        }
    </style>
</head>
<body>
    <div class="section">
        <h1>Member Management</h1>
        <div><h3>Register Member</h3></div>
        <form:form method = "POST" action="/member/memberAdd">
            <div class="link-boxes">
                <label for="name">Name</label>
                <input id="name" type="text" name="name" path="name" class="action-button" placeholder="Enter Full Name" required/>
            </div>

            <div class="link-boxes">
                            <label for="location">Address</label>
                            <input id="location" type="text" name="location" path="addresses[0].location" class="action-button" placeholder="Enter Location" required />
                        </div>

            <div class="link-boxes">
                <label for="phoneNumber">Phone Number</label>
                <input id="phoneNumber" type="text" name="phoneNumber" path="addresses[0].phoneNumber" class="action-button" placeholder="Enter Phone number" required/>
            </div>

            <input type="submit" value="Add Member" class="action-button" />
        </form:form>


        <div class="separator"></div>
                <div><h3>Edit Member</h3></div>
        <form:form method="GET" action="/member/editMember">
                    <div class="link-boxes">
                        <label for="memberId">Member ID</label>
                        <input id="memberId" type="text" name="memberId" class="action-button" placeholder="Enter Valid Member ID" required/>
                    </div>

                    <input type="submit" value="Edit Member" class="action-button" />
                </form:form>

            <div class="separator"></div>
                    <div><h3>Delete Member</h3></div>
            <div>
                <form method="GET" action="/member/delete">
                    <div class="link-boxes">
                        <label for="memberId">Member ID</label>
                        <input id="memberId" type="text" name="memberId" class="action-button" placeholder="Enter Valid Member ID" />
                    </div>
                    <input type="submit" value="Delete Member" class="action-button" />
                </form>
            </div>

            <div class="separator"></div>
            <div><h3>Show All Members</h3></div>
                <div>
                    <form method="GET" action="/member/allMembers">
                        <input type="submit" value="Show All Members" class="action-button" />
                    </form>
                </div>

            <div class="separator"></div>
        <a href="/webmvc/dashboard" class="cancel-button">Cancel</a>
    </div>
    <script>
        var errorMessage = '${error}';
        if (errorMessage) {
            alert(errorMessage);
        }
    </script>

</body>
</html>



