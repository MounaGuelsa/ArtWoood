package com.example.artwood.controlleur;

import com.example.artwood.dao.ProduitDaoImp;
import com.example.artwood.entities.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.List;


@WebServlet("/Produit")
public class ProduitControlleur extends HttpServlet {
    private ProduitDaoImp produitDao = new ProduitDaoImp();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listeProduits(request, response);
                break;
            case "showForm":
                afficherProduit(request, response);
                break;
            case "add":
                ajouterProduit(request, response);
                break;
            case "update":
                modifierProduit(request, response);
                break;
            case "delete":
                supprimerProduit(request, response);
                break;
            default:
                listeProduits(request, response);
        }
    }

    private void listeProduits(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Produit> produits = produitDao.listeProduits();
        request.setAttribute("produits", produits);
        request.getRequestDispatcher("produits.jsp").forward(request, response);
    }

    private void afficherProduit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("ModifierProduit.jsp").forward(request, response);
    }

    private void ajouterProduit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Produit produit = new Produit();
            produit.setDesignation(request.getParameter("designation"));
            produit.setPrix_unit(Double.parseDouble(request.getParameter("prix_unit")));
            produit.setQuantite(Integer.parseInt(request.getParameter("quantite")));
            produitDao.ajouterProduit(produit);
            response.sendRedirect("Produit?action=list");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred while adding the product.");
        }
    }


    private void modifierProduit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Produit produit = new Produit();
            produit.setId_prduit(Integer.parseInt(request.getParameter("id_produit")));
            produit.setDesignation(request.getParameter("designation"));
            produit.setPrix_unit(Double.parseDouble(request.getParameter("prix_unit")));
            produit.setQuantite(Integer.parseInt(request.getParameter("quantite")));
            produitDao.modifierProduit(produit);
            response.sendRedirect("Produit?action=list");
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions appropriately
            response.getWriter().println("An error occurred while updating the product.");
        }
    }

    private void supprimerProduit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int productId = Integer.parseInt(request.getParameter("id_produit"));
            produitDao.supprimerProduit(productId);
            response.sendRedirect("Produit?action=list");
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions appropriately
            response.getWriter().println("An error occurred while deleting the product.");
        }
    }
}
