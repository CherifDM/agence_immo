package com.deme.agence_immo.personne;

import com.deme.agence_immo.database.BDD;
import com.deme.agence_immo.personne.Personne;
import com.deme.agence_immo.personne.PersonneCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PersonneService {

    @Autowired
    private BDD bdd;

    public Personne getPersonneById(String id) {
        try {
            return bdd.getPersonneById(id);
        } catch (SQLException e) {
            System.out.println("Failed to get personne by id : " + id);
            e.printStackTrace();
        }
        return null;
    }

    public List<Personne> getPersonnesByCriteria(PersonneCriteria personneCriteria) {
        try {
            return bdd.getPersonnesByCriteria(personneCriteria);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Personne> getAllPersonnes() {
        try {
            return bdd.getAllPersonnes();
        } catch (SQLException e) {
            System.out.println("Failed to get all personnes");
            e.printStackTrace();
        }
        return null;
    }
}
