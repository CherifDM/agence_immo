package com.deme.agence_immo.offre;

import com.deme.agence_immo.database.BDD;
import com.deme.agence_immo.offre.Offre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class OffreService {

    @Autowired
    private BDD bdd;

    public Offre getOffreById(String id) {
        try {
            return bdd.getOffreById(id);
        } catch (SQLException e) {
            System.out.println("Failed to get offre by id : " + id);
            e.printStackTrace();
        }
        return null;
    }

    public List<Offre> getOffresByCriteria(OffreCriteria offreCriteria) {
        try {
            return bdd.getOffresByCriteria(offreCriteria);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Offre> getAllOffres() {
        try {
            return bdd.getAllOffres();
        } catch (SQLException e) {
            System.out.println("Failed to get all offres");
            e.printStackTrace();
        }
        return null;
    }
}
