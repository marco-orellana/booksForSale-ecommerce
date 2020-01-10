package com.action;

import static com.action.LivreA.listCategory;
import com.entity.Livre;
import com.entity.LivrePanierWrapper;
import com.manager.CategoryM;
import com.manager.LivreM;
import com.manager.PanierM;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class PanierA {

    public static void ajouterAuPanier(HttpServletRequest request,int idLivre) {
        PanierM.add(request, LivreM.getByIdLivre(idLivre));
    }


    public static void enleverDuPanier(HttpServletRequest request,int idLivre) {
        PanierM.removeQty(request, LivreM.getByIdLivre(idLivre));
    }

    public static void afficherPanier(HttpServletRequest request) {
        ArrayList<LivrePanierWrapper> lpw = PanierM.getLivrePanier(request);
         request.setAttribute(listCategory, CategoryM.getAll());
        request.setAttribute("listLivrePanier", lpw);
    }
    public static void viderPanier(HttpServletRequest request){
        PanierM.viderPanier(request);
    }
}
