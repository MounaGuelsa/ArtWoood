<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Login</title>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

<%
    // Check if there is an error message in the session
    String errorMessage = (String) session.getAttribute("errorMessage");
    if (errorMessage != null) {
%>
<div class="alert alert-danger" role="alert">
    <%= errorMessage %>
</div>
<%
    }
%>
<div class="container">
    <form action="Login" method="post">
        <div class="form-group">
            <label for="login">Email:</label>
            <input type="text" class="form-control" id="login" name="login">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" name="password">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    <%
        if(request.getParameter("erreur")!=null &&request.getParameter("erreur").equals("1") )
        {
    %>
    <div class="alert alert-danger" role="alert">
        User or mot de passe est incorrect
    </div>
    <%
        }
    %>
</div>

<!-- Bootstrap JS script link -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
