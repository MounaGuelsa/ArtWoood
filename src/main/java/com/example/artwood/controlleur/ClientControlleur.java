package com.example.artwood.controlleur;

import com.example.artwood.dao.ClientDaoImp;
import com.example.artwood.entities.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/clientServlet")
public class ClientControlleur extends HttpServlet {

    private ClientDaoImp clientDao;

    @Override
    public void init() throws ServletException {
        super.init();
        clientDao = new ClientDaoImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listClients(request, response);
                break;
            case "showForm":
                showClientForm(request, response);
                break;
            case "add":
                addClient(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateClient(request, response);
                break;
            case "delete":
                deleteClient(request, response);
                break;
            default:
                listClients(request, response);
        }
    }

    private void listClients(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Client> clients;
        clients = clientDao.listeClients();
        request.setAttribute("clients", clients);
        request.getRequestDispatcher("clients.jsp").forward(request, response);
    }

    private void showClientForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("ModifierClient.jsp").forward(request, response);
    }

    private void addClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String adresse = request.getParameter("adresse");

        Client newClient = new Client();
        newClient.setNom_client(nom);
        newClient.setPrenom_client(prenom);
        newClient.setAdresse(adresse);

        try {
            clientDao.ajouterClient(newClient);
            response.sendRedirect("clientServlet?action=list");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int clientId = Integer.parseInt(request.getParameter("id"));
        Client existingClient = clientDao.rechercherClient(clientId);
        request.setAttribute("client", existingClient);
        request.getRequestDispatcher("ModifierClient.jsp").forward(request, response);
    }

    private void updateClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int clientId = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String adresse = request.getParameter("adresse");

        Client updatedClient = new Client();
        updatedClient.setId_client(clientId);
        updatedClient.setNom_client(nom);
        updatedClient.setPrenom_client(prenom);
        updatedClient.setAdresse(adresse);

        clientDao.modifierClient(updatedClient);
        response.sendRedirect("clientServlet?action=list");
    }

    private void deleteClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int clientId = Integer.parseInt(request.getParameter("id"));
        clientDao.supprimerClient(clientId);
        response.sendRedirect("clientServlet?action=list");
    }
}