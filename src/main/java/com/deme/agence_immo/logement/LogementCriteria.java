package com.deme.agence_immo.logement;

public class LogementCriteria extends Logement{
    public LogementCriteria(Integer num_logement, Integer nombre_piece, Integer surface_habitable, String id_display_pic, String type_loge, Integer numero, String rue, Integer code_postal, String ville, Integer num_proprio) {
        super(num_logement, nombre_piece, surface_habitable, id_display_pic, type_loge, numero, rue, code_postal, ville, num_proprio);
    }

    public LogementCriteria() {
    }

    public LogementCriteria(Integer num_logement, String ville) {
        super(num_logement, ville);
    }
}
