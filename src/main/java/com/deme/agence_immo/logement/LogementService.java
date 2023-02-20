package com.deme.agence_immo.logement;

import com.deme.agence_immo.database.BDD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LogementService {

    @Autowired
    private BDD bdd;

    public Logement getLogementById(String id) {
        try {
            return bdd.getLogementById(id);
        } catch (SQLException e) {
            System.out.println("Failed to get logement by id : " + id);
            e.printStackTrace();
        }
        return null;
    }

    public List<Logement> getLogementsByCriteria(Logement logementCriteria) {
        try {
            return bdd.getLogementsByCriteria(logementCriteria);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Logement> getAllLogements() {
        try {
            return bdd.getAllLogements();
        } catch (SQLException e) {
            System.out.println("Failed to get all logements");
            e.printStackTrace();
        }
        return null;
    }
}
