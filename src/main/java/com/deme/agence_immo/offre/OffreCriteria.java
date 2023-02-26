package com.deme.agence_immo.offre;

import com.deme.agence_immo.logement.LogementCriteria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OffreCriteria {
    private Integer id_offre;
    private Integer minMontant;
    private Integer maxMontant;
    private List<String> objectif;
    private List<String> etat;
    private Date date_debut;
    private Date date_fin;
    private Integer num_logement;
    private LogementCriteria logementCriteria;
    private Integer disponible;
}
