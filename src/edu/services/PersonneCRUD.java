/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.services;

import edu.entities.Personne;
import edu.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PersonneCRUD {
    
    Connection cnx2;
    
     public PersonneCRUD() {
        cnx2 = MyConnection.getInstance().getCnx();
        
    }
    /*public void ajouterPersonne() {
        try {
            String requete = "UPDATE personne Set activation = ? where id = ?  ";
            Statement st = cnx2.createStatement();
            st.executeUpdate(requete);
            System.out.println("Personne ajoutée!");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }*/

    public void ajouterPersonne2(Personne p,int value) {
        try {
            if (value == 1){
            String requete = "UPDATE personne Set activation = ? Where id = ?  ";
            PreparedStatement pst =cnx2.prepareStatement(requete);
            pst.setInt(1, value);
            pst.setInt(2, p.getId());
   //       pst.setString(3, p.getNumtel());
            
            
            pst.executeUpdate();
            System.out.println("Votre personne est ajoutée!");
            }else { 
               deletePersonne(p.getId());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
     public void updatePersonne(Personne p) {
        try {
            String request = "UPDATE personne Set nom = ?, prenom = ?, numtel = ?, email = ?, mdp = ? where id = ?  ";
            PreparedStatement pst = cnx2.prepareStatement(request);
            pst.setString(1, p.getNom());
            pst.setString(2, p.getPrenom());
            pst.setString(3, p.getNumtel());
            pst.setString(4, p.getEmail());
            pst.setString(5, p.getMdp());
            pst.setInt(6, p.getId());
            pst.executeUpdate();
            System.out.println("Personne modifié! ");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

     public void deletePersonne(int x) {
        try {
            String request = "DELETE FROM personne where id = ?  ";
            PreparedStatement pst = cnx2.prepareStatement(request);
            pst.setInt(1, x);
            pst.executeUpdate();
            System.out.println("Personne");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public List<Personne> affichagePersonnes() {
        List<Personne> myList = new ArrayList();
        try {
            String requete = "SELECT id, nom, prenom,numtel FROM personne";
            Statement st = cnx2.createStatement();
            ResultSet res = st.executeQuery(requete);

            while (res.next()) {
                Personne p = new Personne();
                p.setId(res.getInt(1));
                p.setNom(res.getString("nom"));
                p.setPrenom(res.getString("prenom"));
                p.setNumtel(res.getString("numtel"));
                p.setEmail(res.getString("email"));
                //p.setMdp(res.getString("mdp"));

                myList.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }
}
