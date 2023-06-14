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

            flex-direction: column;
             overflow-y: auto;
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
            margin-bottom: 20px;

        }

        .link-boxes {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
            flex-direction: column;
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
            width: 100%;
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
        <h1>Author Management</h1>

        <form:form action="/author/add_author">

            <div class="link-boxes" style="flex-direction: column">
                <label for="AuthorName">Author Name</label>
                <input id="AuthorName" type="text" name="AuthorName" class="action-button" />
             </div
             <div>
                <label for="country">Country</label>
                <select id="country" name="country" class="action-button">
                    <option value="INDIA">INDIA</option>
                    <option value="USA">USA</option>
                    <option value="UK">UK</option>
                    <option value="Canada">Canada</option>
                </select>
                 <input type="submit" value="Add" class="action-button" />
            </div>
          </form:form>

            <div class="separator"></div>
                 <div><h3>Edit Author</h3></div>
                 <form:form method="GET" action="/author/editAuthor">
                     <div class="link-boxes">
                         <label for="authorId">Author ID</label>
                         <input id="authorId" type="text" name="authorId" class="action-button" placeholder="Enter Valid Author ID" required/>
                     </div>

                     <input type="submit" value="Edit Author" class="action-button" />
                 </form:form>

              <div class="separator"></div>
                     <div><h3>Delete Author</h3></div>
                      <div>
                          <form method="GET" action="/author/delete">
                             <div class="link-boxes">
                              <label for="authorId">Author ID</label>
                                 <input id="authorId" type="text" name="authorId" class="action-button" placeholder="Enter Valid Author ID" />
                             </div>
                              <input type="submit" value="Delete Author" class="action-button" />
                            </form>
                      </div>

             <div class="separator"></div>
             <div><h3>Show All Authors</h3></div>
                 <div>
                     <form method="GET" action="/author/allAuthors">
                         <input type="submit" value="Show All Authors" class="action-button" />
                     </form>
                 </div>

                         <div class="separator"></div>
                     <a href="/webc/dashboard" class="cancel-button">Cancel</a>
                 </div>
</body>
</html>
