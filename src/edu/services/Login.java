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
import javax.swing.JOptionPane;


/**
 *
 * @author iheb
 */
public class Login {
    
    PreparedStatement ps;
    Connection con = null;
    ResultSet rs = null;
    
   
    public void registration (Personne p) { 
        con =MyConnection.getInstance().getCnx();
        int activation = 0;
        try {
            
         String requete = " INSERT INTO personne (id, nom , prenom,numtel,email,mdp,activation) VALUES (?,?,?,?,?,?,?)";
         
            PreparedStatement pst =con.prepareStatement(requete);
            pst.setInt(1, p.getId());
            pst.setString(2, p.getNom());
            pst.setString(3, p.getPrenom());
            pst.setString(4, p.getNumtel());
            pst.setString(5, p.getEmail());
            pst.setString(6, p.getMdp());
            pst.setInt(7, activation);
            
            pst.executeUpdate();
            System.out.println("Votre personne est ajoutée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
          
    
    }
    
    
    
    public void loginn(Personne p){
        
        con =MyConnection.getInstance().getCnx();
        try {
        
            String sql = "SELECT * FROM personne where nom like ? AND mdp like ? AND activation like ? " ;
            ps = con.prepareCall(sql);
            
            ps.setString(1, p.getNom());
            ps.setString(2, p.getMdp());
            ps.setInt(3, 1);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                System.out.println("Order is now under admin validation");
                
                
            }else {
                System.out.println("connexion échoué");
            }
            
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
                      
    
    }
        
                            

    
}
