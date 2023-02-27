package com.deme.agence_immo.personne;

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
public class PersonneCriteria {
    private Integer num_client;
    private String nom;
    private String prenom;
    private Integer numero;
    private String rue;
    private Integer code_postal;
    private List<String> ville;
}
