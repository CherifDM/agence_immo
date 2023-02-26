package com.deme.agence_immo.offre;

import com.deme.agence_immo.offre.Offre;
import com.deme.agence_immo.offre.OffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OffreController {
    
    @Autowired
    private OffreService offreService;

    /**
     * GET Request
     * Return offre object that is assigned to the id received
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping("/api/offres/{id}")
    public Offre getOffreById(@PathVariable String id){
        return offreService.getOffreById(id);
    }

    /**
     * GET Request
     * Return list of all offres
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping("/api/offres")
    public List<Offre> getOffres(){
        return offreService.getAllOffres();
    }

    /**
     * POST Request
     * Return list of offre objects that are assigned to category names received
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(method= RequestMethod.POST,value="/api/offres/search")
    @ResponseBody
    public List<Offre> getOffresByCriteria(@RequestBody OffreCriteria offreCriteria){
        return offreService.getOffresByCriteria(offreCriteria);
    }



}
