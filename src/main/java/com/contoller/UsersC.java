/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contoller;

import static com.action.LivreA.listCategory;
import com.entity.User;
import com.manager.CategoryM;
import com.manager.SessionM;
import com.manager.UserM;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author morellan
 */
@WebServlet(name = "UserC", urlPatterns = {"/usersC"})
public class UsersC extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String urlRetour = "";
        String logout = request.getParameter("logout");
        String login = request.getParameter("login");
        String inscription = request.getParameter("inscription");
        String lEmail = request.getParameter("lEmail");
        String lPassword = request.getParameter("lPassword");
        User lUser = null;
        
        if (lEmail !=null && lPassword != null){
            lUser = new User(lEmail, lPassword);
        }
        
        if (logout != null) {
            SessionM.logOut(request);
            urlRetour = "livreC";
        } else if (login != null) {
            urlRetour = "login.jsp";
        } else if (inscription != null) {
            urlRetour = "inscriptionC";
        } else if (lUser!= null) {
            UserM.checkLogin(lUser);
            SessionM.add(request, "user", lUser);
            urlRetour = "livreC";

        }

        //afficher category
        request.setAttribute(listCategory, CategoryM.getAll());

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
