<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #778899;
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
            width: 350px;
            color: #fff;
        }

        .link-boxes {
            display: flex;
            flex-direction: column;
            margin-bottom: 20px;
        }

        .action-button {
            display: block;
            background-color: #F5F5F5;
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
            margin-right: 0;
        }

        .action-button:hover {
            background-color: #E8E8E8;
        }

        .cancel-button {
            display: block;
            background-color: #F5F5F5;
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
        <h1>Book Registration</h1>
        <div><h3>Register Book</h3></div>

        <form:form action="/book/addBook" method="POST" modelAttribute="book">
            <div class="link-boxes">
                <label for="bookName">Book Name</label>
                <input id="bookName" type="text" name="bookName" class="action-button" />
            </div>

            <div class="link-boxes">
                <label for="edition">Edition</label>
                <input id="edition" type="text" name="edition" class="action-button" />
            </div>

            <div class="link-boxes">
                <label for="noOfPages">Number of Pages</label>
                <input id="noOfPages" type="number" name="noOfPages" class="action-button" />
            </div>

            <div class="link-boxes">
                <label for="authorId">Author</label>
                <select id="authorId" name="authorId" class="action-button">
                    <option value="1">JK Rowling</option>
                    <option value="2">William Faulkner</option>
                    <option value="3">Ayn Rand</option>
                    <option value="4">George Orwell</option>
                    <option value="5">Harold Robins</option>
                </select>
            </div>

            <div class="link-boxes">
                <label for="publisherId">Publisher</label>
                <select id="publisherId" name="publisherId" class="action-button">
                    <option value="1">MacMillan India</option>
                    <option value="2">Hachette Book</option>
                    <option value="3">Simon & Schuster</option>
                    <option value="4">Gannet</option>
                    <option value="5">Bloomberg</option>
                </select>
            </div>

            <div class="link-boxes">
                <label for="categoryId">Category</label>
                <select id="categoryId" name="categoryId" class="action-button">
                    <option value="1">Fiction</option>
                    <option value="2">Novel</option>
                    <option value="3">Mystery</option>
                    <option value="4">Code</option>
                    <option value="5">Short Story</option>
                </select>
            </div>

            <input type="submit" value="Add" class="action-button" />
        </form:form>

        <div class="separator"></div>
                        <div><h3>Edit Book</h3></div>
                <form:form method="GET" action="/book/editBook">
                            <div class="link-boxes">
                                <label for="bookId">Book ID</label>
                                <input id="bookId" type="number" name="bookId" class="action-button" placeholder="Enter Valid Book ID" required/>
                            </div>

                            <input type="submit" value="Edit Book" class="action-button" />
                        </form:form>

                    <div class="separator"></div>
                            <div><h3>Delete Book</h3></div>
                    <div>
                        <form method="GET" action="/book/delete">
                            <div class="link-boxes">
                                <label for="bookId">Book ID</label>
                                <input id="bookId" type="text" name="bookId" class="action-button" placeholder="Enter Valid Book ID" />
                            </div>
                            <input type="submit" value="Delete Book" class="action-button" />
                        </form>
                    </div>

                    <div class="separator"></div>
                    <div><h3>Show All Books</h3></div>
                        <div>
                            <form method="GET" action="/book/allBooks">
                                <input type="submit" value="Show All Books" class="action-button" />
                            </form>
                        </div>

                    <div class="separator"></div>
                <a href="/webmvc/dashboard" class="cancel-button">Cancel</a>

    </div>
</body>
</html>
