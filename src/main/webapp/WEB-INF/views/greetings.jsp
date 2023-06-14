<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admission Page</title>
</head>
<body>
<h2>${welcome_msg}</h2>
<hr />
<a id="en" href="/i18n?lang=en">English</a> | <a id="fr" href="/i18n?lang=fr">French</a>
<div> </div>

<div id="welcome_text">
    <h2><spring:message code="welcome.message" /></h2>
</div>
</body>
</html>
