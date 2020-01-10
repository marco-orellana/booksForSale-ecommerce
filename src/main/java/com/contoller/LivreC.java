/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contoller;

import com.action.LivreA;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fgaudrea
 */
@WebServlet(name = "LivreC", urlPatterns = {"/livreC"})
public class LivreC extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String urlRetour = "index.jsp";

        String byName = request.getParameter("byName");
        String idLivre = request.getParameter("idLivre");
        String idCategory = request.getParameter("idCategory");
        String maxPage = request.getParameter("maxPage");
        String idLivreForCart = request.getParameter("idLivreForCart");

        if (byName != null) {
            LivreA.afficherByName(request, byName);
        } else if (idLivre != null) {
            LivreA.afficherByIdLivre(request, Integer.parseInt(idLivre));
            urlRetour = "book_detail.jsp";
        } else if (idCategory != null && !idCategory.equals("all")) {
            LivreA.afficherByIdCategory(request, Integer.parseInt(idCategory));
        } else if (maxPage != null) {
            LivreA.afficherByNbPages(request, 0, Integer.parseInt(maxPage));
        } else if (idLivreForCart != null) {
            LivreA.ajouterAuPanier(request, Integer.parseInt(idLivreForCart));
            urlRetour = "panierC";
        } else {
            LivreA.afficherAll(request);
        }

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
