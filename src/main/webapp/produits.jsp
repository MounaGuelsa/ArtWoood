<%@ page import="java.util.*" %>
<%@ page import="com.example.artwood.entities.Produit" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <title>Liste des Produits</title>
</head>

<body class="flex flex-col h-screen">



<div class="flex-grow px-4 sm:px-6 lg:px-8">
    <%@include file="navbar.jsp" %>
    <div class="sm:flex sm:items-center mb-4">

        <div class="sm:flex-auto">
            <h1 class="text-xl font-semibold text-gray-900">La liste des produits</h1>
        </div>

        <form action="ajouterProduit.jsp" method="get">
            <button type="submit"
                    class="inline-flex items-center justify-center rounded-md border border-transparent bg-indigo-600 px-4 py-2 text-sm font-medium text-white shadow-sm hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2 sm:w-auto">
                Ajouter produit
            </button>
        </form>

    </div>

    <div class="-mx-4 overflow-hidden shadow ring-1 ring-black ring-opacity-5 sm:-mx-6 md:mx-0 md:rounded-lg">
        <table class="min-w-full divide-y divide-gray-300">
            <thead class="bg-gray-50">
            <tr>
                <th scope="col" class="py-3.5 pl-4 pr-3 text-left text-sm font-semibold text-gray-900 sm:pl-6">
                    Référence
                </th>
                <th scope="col" class="hidden px-3 py-3.5 text-left text-sm font-semibold text-gray-900 sm:table-cell">
                    Designation
                </th>
                <th scope="col" class="hidden px-3 py-3.5 text-left text-sm font-semibold text-gray-900 lg:table-cell">
                    Prix unitaire
                </th>
                <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Stock</th>
                <th scope="col" class="px-3 py-3.5 text-left text-sm font-semibold text-gray-900">Actions</th>
            </tr>
            </thead>
            <tbody class="divide-y divide-gray-200 bg-white">
            <%
                List<Produit> produits = (List<Produit>) request.getAttribute("produits");
                if (produits != null && !produits.isEmpty()) {
                    for (Produit produit : produits) {
            %>
            <tr>
                <td class="whitespace-nowrap py-4 pl-4 pr-3 text-sm font-medium text-gray-900 sm:pl-6"><%= produit.getId_prduit() %>
                </td>
                <td class="hidden whitespace-nowrap px-3 py-4 text-sm text-gray-500 sm:table-cell"><%= produit.getDesignation() %>
                </td>
                <td class="hidden whitespace-nowrap px-3 py-4 text-sm text-gray-500 lg:table-cell"><%= produit.getPrix_unit() %>
                </td>
                <td class="whitespace-nowrap px-3 py-4 text-sm text-gray-500"><%= produit.getQuantite() %>
                </td>
                <td>
                    <button
                            type="button"
                            class="btn btn-link btn-rounded btn-sm fw-bold"
                            data-mdb-ripple-color="dark">
                        <a href="Produit?action=modifierProduit&id_produit=<%= produit.getId_prduit() %>">Modifier </a>
                        <!-- Uncomment the line below if you want to include the delete link -->
                        <!-- <a href="Produit?action=delete&id_produit=${produit.id_prduit}">Supprimer</a> -->
                    </button>
                </td>

            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="4">Aucun produit disponible</td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>

</div>

</body>
</html>
