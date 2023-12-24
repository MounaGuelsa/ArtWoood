package com.example.artwood.controlleur;


import com.example.artwood.dao.ProduitDaoImp;
import com.example.artwood.dao.UserDaoImp;
import com.example.artwood.entities.Produit;
import com.example.artwood.entities.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// ...

@WebServlet("/Login")
public class UserControlleur extends HttpServlet {
    private static final long serialVersionUID = 1L;
    //private static final Logger logger = LogManager.getLogger(UserControlleur.class);
    private ProduitDaoImp produitDao = new ProduitDaoImp();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserDaoImp userDao = new UserDaoImp();
        User user = userDao.authenticateUser(login, password);

        if (user != null) {
            session.setAttribute("user", user);
            //logger.info("Utilisateur authentifié : {}", user.getNom_user());
            List<Produit> produits = produitDao.listeProduits();
            request.setAttribute("produits", produits);
            request.getRequestDispatcher("/produits.jsp").forward(request, response);

        } else {
            response.sendRedirect(request.getContextPath() + "?erreur=1");
            //logger.warn("Échec de l'authentification pour le login : {}", login);
        }
    }
}

