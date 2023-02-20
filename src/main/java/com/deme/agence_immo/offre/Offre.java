package com.deme.agence_immo.offre;

import java.util.Date;

public class Offre {
    private Integer id_offre;
    private Integer montant;
    private String objectif;
    private String etat;
    private Date date_debut;
    private Date date_fin;
    private Integer num_logement;

    public Offre(Integer id_offre, Integer montant, String objectif, String etat, Date date_debut, Date date_fin, Integer num_logement) {
        this.id_offre = id_offre;
        this.montant = montant;
        this.objectif = objectif;
        this.etat = etat;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.num_logement = num_logement;
    }

    public Integer getId_offre() {
        return id_offre;
    }

    public void setId_offre(Integer id_offre) {
        this.id_offre = id_offre;
    }

    public Integer getMontant() {
        return montant;
    }

    public void setMontant(Integer montant) {
        this.montant = montant;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Integer getnum_logement() {
        return num_logement;
    }

    public void setnum_logement(Integer num_logement) {
        this.num_logement = num_logement;
    }
}
