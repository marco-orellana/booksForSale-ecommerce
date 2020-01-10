/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import static com.action.LivreA.listCategory;
import static com.action.LivreA.listLivre;
import com.entity.Livre;
import com.manager.CategoryM;
import com.manager.CommandeM;
import com.manager.LivreM;
import com.manager.PanierM;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author fgaudrea
 */
public class CommandeA {
    
      public static void ajouterCommande(int idUser) {
        CommandeM.addCommande(idUser);
    }
      
      public static void ajouterCommandeList(int idCommande, int idUser, int qty) {
        CommandeM.addCommandeList(idCommande, idUser, qty);
    }
}
