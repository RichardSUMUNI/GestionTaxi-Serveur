/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import Modele.Taxi;
import Modele.TaxiDAO;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Richard.Sumuni
 */
@WebService(serviceName = "Services")
public class Services {
    TaxiDAO dao = new TaxiDAO();
    @WebMethod(operationName = "liste")
    public List<Taxi> liste() {
        List<Taxi> donnees = dao.liste();
        
        return donnees;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ajouter")
    public String ajouter(@WebParam(name = "numeroTaxi") String numeroTaxi, @WebParam(name = "modeleVoiture") String modeleVoiture, @WebParam(name = "adresse") String adresse, @WebParam(name = "ville") String ville, @WebParam(name = "pays") String pays) {
        
        String donnees = dao.ajouter(numeroTaxi, modeleVoiture, adresse, ville, pays);
        return donnees;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listeID")
    public Taxi listeID(@WebParam(name = "id") int id) {
        Taxi taxi = dao.listeID(id);
        
        return taxi;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Actualiser")
    public String Actualiser(@WebParam(name = "id") int id, @WebParam(name = "numeroTaxi") String numeroTaxi, @WebParam(name = "modeleVoiture") String modeleVoiture, @WebParam(name = "adresse") String adresse, @WebParam(name = "ville") String ville, @WebParam(name = "pays") String pays) {
       String donnees = dao.modifier(id, numeroTaxi, modeleVoiture, adresse, ville, pays);
       
        return donnees;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Supprimer")
    public Taxi Supprimer(@WebParam(name = "id") int id) {
        Taxi t = dao.supprimer(id);
        
        return t;
    }
}
