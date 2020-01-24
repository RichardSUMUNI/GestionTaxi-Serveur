/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.List;

/**
 *
 * @author Richard.Sumuni
 */
public interface CRUD {
    public List liste();
    public Taxi listeID (int id);
    public String ajouter(String numeroTaxi, String modeleVoiture, String adresse, String ville, String pays);
    public String modifier(int id, String numeroTaxi, String modeleVoiture, String adresse, String ville, String pays);
    public Taxi supprimer(int id);
}
