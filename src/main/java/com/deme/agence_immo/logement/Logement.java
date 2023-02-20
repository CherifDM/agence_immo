package com.deme.agence_immo.logement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Logement {
    private Integer num_logement;
    private Integer nombre_piece;
    private Integer surface_habitable;
    private String id_display_pic;
    private String type_loge;
    private Integer numero;
    private String rue;
    private Integer code_postal;
    private String ville;
    private Integer num_proprio;

    public Logement(Integer num_logement, String ville) {
        this.num_logement = num_logement;
        this.ville = ville;
    }
}
