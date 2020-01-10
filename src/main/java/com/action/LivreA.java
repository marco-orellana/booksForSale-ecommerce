/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.manager.CategoryM;
import com.manager.LivreM;
import com.manager.PanierM;
import com.sun.net.httpserver.HttpServer;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author fgaudrea
 */
public class LivreA {
    
     public static final String listLivre = "listLivre";
     public static final String listCategory = "listCategory";
     public static final String livreById = "livreById";
    
    public static void afficherAll(HttpServletRequest request){
        request.setAttribute(listLivre, LivreM.getAll());
        request.setAttribute(listCategory, CategoryM.getAll());
    }
    
    public static void afficherByIdCategory(HttpServletRequest request, int idCategory){
        request.setAttribute(listLivre, LivreM.getByIdCategory(idCategory));
        request.setAttribute(listCategory, CategoryM.getAll());
    }
    
    public static void afficherByNbPages(HttpServletRequest request, int minPage, int maxPage){
        request.setAttribute(listLivre, LivreM.getByNbPages(minPage, maxPage));
        request.setAttribute(listCategory, CategoryM.getAll());
    }
    
    public static void afficherByName(HttpServletRequest request, String name){
        request.setAttribute(listLivre, LivreM.getByName(name));
        request.setAttribute(listCategory, CategoryM.getAll());
    }
    
    public static void afficherByIdLivre(HttpServletRequest request, int idLivre){
        request.setAttribute(livreById, LivreM.getByIdLivre(idLivre));
        request.setAttribute(listCategory, CategoryM.getAll());
    }
    public static void ajouterAuPanier(HttpServletRequest request, int idLivre){
        PanierM.add(request, LivreM.getByIdLivre(idLivre));
    }
}
