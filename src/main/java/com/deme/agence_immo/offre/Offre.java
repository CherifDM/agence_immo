package com.deme.agence_immo.offre;

import com.deme.agence_immo.logement.Logement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Offre {
    private Integer id_offre;
    private Integer montant;
    private String objectif;
    private String etat;
    private Date date_debut;
    private Date date_fin;
    private Integer num_logement;
    private Logement logement;
    private Integer disponible;


}
