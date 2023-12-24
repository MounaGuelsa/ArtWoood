<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.artwood.entities.Client" %>

<html>
<head>
  <title>Client Form</title>
</head>
<body>
<h2>Client Form</h2>

<form action="clientServlet" method="post">
  <input type="hidden" name="action" value="${client != null ? 'update' : 'add'}">
  <input type="hidden" name="id" value="${client != null ? client.client_id : ''}">

  <label for="nom">Last Name:</label>
  <input type="text" id="nom" name="nom" value="${client != null ? client.nom_client : ''}" required><br>

  <label for="prenom">First Name:</label>
  <input type="text" id="prenom" name="prenom" value="${client != null ? client.prenom_client : ''}" required><br>

  <label for="adresse">Address:</label>
  <input type="text" id="adresse" name="adresse" value="${client != null ? client.adresse : ''}" required><br>

  <input type="submit" value="${client != null ? 'Update' : 'Add'}">
</form>

<br>
<a href="clientServlet?action=list">Back to Client List</a>
</body>
</html>
