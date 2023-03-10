package com.deme.agence_immo.personne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personne {
    private Integer num_client;
    private String nom;
    private String prenom;
    private Integer numero;
    private String rue;
    private Integer code_postal;
    private String ville;
}
