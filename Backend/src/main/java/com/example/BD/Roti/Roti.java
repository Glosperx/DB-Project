package com.example.BD.Roti;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "ROTI")
public class Roti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_roti")
    private int ID_ROTI;

    @JsonProperty("dimensiune_roti")
    @Column(name = "Dimensiune_Roti", nullable = false)
    private double dimensiuneRoti;

    @JsonProperty("culoare_roti")
    @Column(name = "Culoare_Roti", nullable = false)
    private String culoareRoti;

    @JsonProperty("denumire_roti")
    @Column(name = "Denumire_Roti", nullable = false, unique = true)
    private String denumireRoti;

    @JsonProperty("pret_roti")
    @Column(name = "Pret_Roti", nullable = false)
    private double pretRoti;

    public Roti() {}

    public Roti(double dimensiuneRoti, String culoareRoti, String denumireRoti, double pretRoti) {
        this.dimensiuneRoti = dimensiuneRoti;
        this.culoareRoti = culoareRoti;
        this.denumireRoti = denumireRoti;
        this.pretRoti = pretRoti;
    }

    public int getIdRoti() {
        return ID_ROTI;
    }

    public void setIdRoti(int idRoti) {
        this.ID_ROTI = idRoti;
    }

    public double getDimensiuneRoti() {
        return dimensiuneRoti;
    }

    public void setDimensiuneRoti(double dimensiuneRoti) {
        this.dimensiuneRoti = dimensiuneRoti;
    }

    public String getCuloareRoti() {
        return culoareRoti;
    }

    public void setCuloareRoti(String culoareRoti) {
        this.culoareRoti = culoareRoti;
    }

    public String getDenumireRoti() {
        return denumireRoti;
    }

    public void setDenumireRoti(String denumireRoti) {
        this.denumireRoti = denumireRoti;
    }

    public double getPretRoti() {
        return pretRoti;
    }

    public void setPretRoti(double pretRoti) {
        this.pretRoti = pretRoti;
    }

    @Override
    public String toString() {
        return "Roti{" +
                "idRoti=" + ID_ROTI +
                ", dimensiuneRoti=" + dimensiuneRoti +
                ", culoareRoti='" + culoareRoti + '\'' +
                ", denumireRoti='" + denumireRoti + '\'' +
                ", pretRoti=" + pretRoti +
                '}';
    }
}
