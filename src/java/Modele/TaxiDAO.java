/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Richard.Sumuni
 */
public class TaxiDAO implements CRUD{

    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Connexion conex = new Connexion();
    int res;
    String message;
    Taxi taxi = new Taxi();
    
    @Override
    public List liste() {
        List<Taxi> donnees = new ArrayList<>();
        String sql = "SELECT * FROM taxi";
        try {
            con = conex.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs  = ps.executeQuery();
            while(rs.next()){
                Taxi t = new Taxi();
                t.setId(rs.getInt("id"));
                t.setNumeroTaxi(rs.getString("numeroTaxi"));
                t.setModeleVoiture(rs.getString("modeleVoiture"));
                t.setAdresse(rs.getString("adresse"));
                t.setVille(rs.getString("ville"));
                t.setPays(rs.getString("pays"));
                
                donnees.add(t);
            }
        } catch (Exception e) {
        }
        
        return donnees;
    }

    @Override
    public Taxi listeID(int id) {
        String sql = "SELECT * FROM Taxi WHERE id = " + id;
        
        try {
            con = conex.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs  = ps.executeQuery();
            while(rs.next()){
                
                taxi.setId(rs.getInt("id"));
                taxi.setNumeroTaxi(rs.getString("numeroTaxi"));
                taxi.setModeleVoiture(rs.getString("modeleVoiture"));
                taxi.setAdresse(rs.getString("adresse"));
                taxi.setVille(rs.getString("ville"));
                taxi.setPays(rs.getString("pays"));
              
            }
        } catch (Exception e) {
        }
        return taxi;
    }

    @Override
    public String ajouter(String numeroTaxi, String modeleVoiture, String adresse, String ville, String pays) {
        
        String requete = "INSERT INTO Taxi(numeroTaxi, modeleVoiture, adresse, ville, pays) VALUES (?,?,?,?,?)";
        try {
            con = conex.getConnection();
            ps = (PreparedStatement) con.prepareStatement(requete);
            ps.setString(1, numeroTaxi);
            ps.setString(2, modeleVoiture);
            ps.setString(3, adresse);
            ps.setString(4, ville);
            ps.setString(5, pays);
            res = ps.executeUpdate();
            if(res==1)
            {
                message = "Taxi ajouté avec succès";
            }else
            {
                message = "Une erreur est survenue lors de l'ajout d'un taxi";
            }
        } catch (Exception e) {
        }
        
        return message;
    }

    @Override
    public String modifier(int id, String numeroTaxi, String modeleVoiture, String adresse, String ville, String pays) {
        String sql = "UPDATE Taxi SET numeroTaxi=?, modeleVoiture=?, adresse=?, ville=?, pays=? WHERE id=" + id;
        try {
            con = conex.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, numeroTaxi);
            ps.setString(2, modeleVoiture);
            ps.setString(3, adresse);
            ps.setString(4, ville);
            ps.setString(5, pays);
            res = ps.executeUpdate();
            if(res == 1){
                message = "Taxi actualisé...";
            }else{
                message = "Une erreur est survenue lors de la modification du taxi";
            }
        } catch (Exception e) {
        }
        
        return message;
    }

    @Override
    public Taxi supprimer(int id) {
        String sql = "DELETE FROM Taxi WHERE id = " +id;
        try {
            con = conex.getConnection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
        
        return taxi;
    }
    
}
