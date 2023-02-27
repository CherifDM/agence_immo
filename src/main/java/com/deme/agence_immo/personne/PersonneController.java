package com.deme.agence_immo.personne;

import com.deme.agence_immo.personne.Personne;
import com.deme.agence_immo.personne.PersonneCriteria;
import com.deme.agence_immo.personne.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonneController {
    
    @Autowired
    private PersonneService personneService;

    /**
     * GET Request
     * Return personne object that is assigned to the id received
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping("/api/personnes/{id}")
    public Personne getPersonneById(@PathVariable String id){
        return personneService.getPersonneById(id);
    }

    /**
     * GET Request
     * Return list of all personnes
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping("/api/personnes")
    public List<Personne> getPersonnes(){
        return personneService.getAllPersonnes();
    }

    /**
     * POST Request
     * Return list of personne objects that are assigned to category names received
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(method= RequestMethod.POST,value="/api/personnes/search")
    @ResponseBody
    public List<Personne> getPersonnesByCriteria(@RequestBody PersonneCriteria personneCriteria){
        return personneService.getPersonnesByCriteria(personneCriteria);
    }



}
