<%@ page import="java.util.*" %>
<%@ page import="com.example.artwood.entities.Produit" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- ... (head content remains unchanged) ... -->
    <title>Ajouter un produit</title>
</head>

<body class="flex flex-col h-screen">

<%@include file="navbar.jsp" %>

<div class="flex-grow px-4 sm:px-6 lg:px-8">

    <div class="sm:flex sm:items-center mb-4">
        <div class="sm:flex-auto">
            <h1 class="text-xl font-semibold text-gray-900">Ajouter un nouveau produit</h1>
        </div>
    </div>

    <div class="-mx-4 overflow-hidden shadow ring-1 ring-black ring-opacity-5 sm:-mx-6 md:mx-0 md:rounded-lg">
        <form action="Produit?action=add" method="post">
            <div class="mb-3">
                <label for="designation" class="form-label">Designation</label>
                <input type="text" class="form-control" id="designation" name="designation" required>
            </div>
            <div class="mb-3">
                <label for="prix_unit" class="form-label">Prix unitaire</label>
                <input type="number" step="0.01" class="form-control" id="prix_unit" name="prix_unit" required>
            </div>
            <div class="mb-3">
                <label for="quantite" class="form-label">Quantité en stock</label>
                <input type="number" class="form-control" id="quantite" name="quantite" required>
            </div>
            <button type="submit" class="btn btn-primary">Ajouter le produit</button>
        </form>
    </div>

</div>

</body>
</html>

