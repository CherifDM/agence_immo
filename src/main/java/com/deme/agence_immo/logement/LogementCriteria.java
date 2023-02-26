package com.deme.agence_immo.logement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogementCriteria{
    private Integer num_logement;
    private Integer nombre_pieces;
    private Integer max_Surface_habitable;
    private Integer min_Surface_habitable;
    private Integer min_nombre_pieces;
    private Integer max_nombre_pieces;
    private String id_display_pic;
    private List<String> type_loge;
    private Integer numero;
    private String rue;
    private Integer code_postal;
    private List<String> ville;
    private Integer num_proprio;

}

