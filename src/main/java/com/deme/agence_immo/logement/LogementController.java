package com.deme.agence_immo.logement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LogementController {
    
    @Autowired
    private LogementService logementService;

    /**
     * GET Request
     * Return logement object that is assigned to the id received
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping("/api/logements/{id}")
    public Logement getLogementById(@PathVariable String id){
        return logementService.getLogementById(id);
    }

    /**
     * GET Request
     * Return list of all logements
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping("/api/logements")
    public List<Logement> getLogements(){
        return logementService.getAllLogements();
    }

    /**
     * POST Request
     * Return list of logement objects that are assigned to category names received
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(method= RequestMethod.POST,value="/api/logements/search")
    @ResponseBody
    public List<Logement> getLogementsByCriteria(@RequestBody Logement logementCriteria){
        return logementService.getLogementsByCriteria(logementCriteria);
    }



}
