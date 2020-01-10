/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manager;

import com.entity.User;
import com.service.ConnectionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rwang
 */
public class UserM {

    /**
     * check login
     *
     * @param user
     * @return
     */
    private static int idUser = 0;

    public static User checkLogin(User user) {
        User retour = null;
        String sql = "SELECT * FROM user WHERE email like ? AND password like ?";
        PreparedStatement ps = ConnectionDB.getPs(sql);
        ResultSet result;
        try {
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            result = ps.executeQuery();
            if (result.isBeforeFirst()) {
                retour = new User();
                while (result.next()) {
                    retour.setId(result.getInt("id"));
                    retour.setEmail(result.getString("email"));
                    retour.setPassword(result.getString("password"));
                    retour.setPrenom(result.getString("prenom"));
                    retour.setNom(result.getString("nom"));
                    retour.setRole(result.getInt("idRole"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.close();
        }

        return retour;
    }

    public static int addUser(User user) {
        String sql = "INSERT INTO user VALUES(?,?, ?, ?, ?, ?)";
        int gg = -1;
        PreparedStatement ps = ConnectionDB.getPs(sql);
        try {
            ps.setInt(1, idUser++);
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getPrenom());
            ps.setString(5, user.getNom());
            ps.setInt(6, user.getRole());

            gg = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserM.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.close();
        }
        return gg;
    }

}
