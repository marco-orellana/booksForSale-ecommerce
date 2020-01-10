package com.contoller;


import com.action.PanierA;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PanierC", urlPatterns = {"/panierC"})
public class PanierC extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String ajouterArticle = request.getParameter("ajouterArticle");
        String retirerArticle = request.getParameter("retirerArticle");
        String viderPanier = request.getParameter("viderPanier");
        String passerCommande = request.getParameter("passerCommande");
        String idLivreString = request.getParameter("idLivre");

        String urlRetour = "panier.jsp";

        if (ajouterArticle != null && idLivreString != null) {
            int idLivre = Integer.parseInt(idLivreString);
            PanierA.ajouterAuPanier(request, idLivre);
        } else if (retirerArticle != null && idLivreString != null) {
            int idLivre = Integer.parseInt(idLivreString);
            PanierA.enleverDuPanier(request, idLivre);
        } else if (viderPanier != null) {
            PanierA.viderPanier(request);
        } else if (passerCommande != null) {
            PanierA.viderPanier(request);
        }

        PanierA.afficherPanier(request);
       
         
        request.getRequestDispatcher(urlRetour).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
