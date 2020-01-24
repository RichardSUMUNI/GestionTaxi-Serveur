/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Richard.Sumuni
 */
public class Connexion {
    Connection con;
    public Connexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String chaineConnexion="jdbc:mysql://localhost:3306/db_taxi";
            con=DriverManager.getConnection(chaineConnexion, "root", "Bin.netzero10");
        } catch (Exception e) {
        }
    }
    
    public Connection getConnection(){
        return con;
    }
    
}
