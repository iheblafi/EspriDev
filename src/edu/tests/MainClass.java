/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tests;

import edu.entities.Personne;
import edu.services.Login;
import edu.services.PersonneCRUD;
import edu.utils.MyConnection;
import java.util.List;

/**
 *
 * @author iheb
 */
public class MainClass {
    public static void main(String[] args) {
        //MyConnection mc = new MyConnection();
        Login log = new Login();
        
        PersonneCRUD pcd = new PersonneCRUD();
       //pcd.ajouterPersonne();
       //pcd.deletePersonne(1);
       Personne p = new Personne(1,"Lafi", "Iheb", "55252545", "iheb.la@gmail.com", "ffhfhf");
      //log.registration(p);
       
       //pcd.ajouterPersonne2(p,1);
       ///log.loginn(p);
       //pcd.updatePersonne(p);
       List<Personne> listPersons = pcd.affichagePersonnes();
       
      for(Personne per : listPersons){
        System.out.println(per);
      }
       
        MyConnection m1 = MyConnection.getInstance();
        MyConnection m2 = MyConnection.getInstance();
        System.out.println(m1.hashCode() + "  ----  "+m2.hashCode());
    }
    
}
