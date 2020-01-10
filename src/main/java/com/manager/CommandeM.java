/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manager;

import com.entity.CommandeWrapper;
import com.entity.Livre;
import com.entity.User;
import com.service.ConnectionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fgaudrea
 */
public class CommandeM {

    private static final String queryAddCommande = "INSERT INTO commande VALUES (?,?)";
    private static final String queryAddCommandeList = "INSERT INTO commandelist VALUES (?,?,?)";
    private static final String queryGetCommande = "SELECT * FROM commande WHERE idUser = ?";
    private static final String queryGetCommandeList = "SELECT * FROM commandelist WHERE idCommande = ?";

    public static void addCommande(int idUser) {
        PreparedStatement ps = ConnectionDB.getPs(queryAddCommande);

        try {
            ps.setInt(1, idUser);
            ps.setString(2, new Date().toString());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LivreM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.close();
        }
    }

    public static void addCommandeList(int idCommande, int idLivre, int qty) {
        PreparedStatement ps = ConnectionDB.getPs(queryAddCommandeList);

        try {
            ps.setInt(1, idCommande);
            ps.setInt(2, idLivre);
            ps.setInt(3, qty);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LivreM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.close();
        }
    }

    public static ArrayList<CommandeWrapper> getByIdCommande(int idCommande) {
        ArrayList<CommandeWrapper> commande = null;

        PreparedStatement ps = ConnectionDB.getPs(queryGetCommande);
        ResultSet result;
        try {
            ps.setInt(1, idCommande);
            result = ps.executeQuery();
            if (result.isBeforeFirst()) {
                commande = new ArrayList<>();
                while (result.next()) {
                    commande.add(new CommandeWrapper(result.getInt("id"),
                            result.getInt("idLivre"),
                            result.getInt("qty")
                    ));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LivreM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.close();
        }

        return commande;
    }

}
