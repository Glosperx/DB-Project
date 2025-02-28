package com.example.BD.Culoare;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "CULOARE")
public class Culoare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_culoare")
    private int ID_CULOARE;

    @JsonProperty("nume_culoare")
    @Column(name = "Nume_Culoare", nullable = false, unique = true)
    private String numeCuloare;

    @JsonProperty("pret_culoare")
    @Column(name = "Pret_Culoare", nullable = false)
    private double pretCuloare;

    @JsonProperty("tip_finisaj")
    @Column(name = "Tip_Finisaj", nullable = false)
    private String tipFinisaj;

    // Constructor fără parametri
    public Culoare() {}

    // Constructor cu parametri pentru inițializare
    public Culoare(String numeCuloare, double pretCuloare, String tipFinisaj) {
        this.numeCuloare = numeCuloare;
        this.pretCuloare = pretCuloare;
        this.tipFinisaj = tipFinisaj;
    }

    // Getters și Setters
    public int getIdCuloare() {
        return ID_CULOARE;
    }

    public void setIdCuloare(int idCuloare) {
        this.ID_CULOARE = idCuloare;
    }

    public String getNumeCuloare() {
        return numeCuloare;
    }

    public void setNumeCuloare(String numeCuloare) {
        this.numeCuloare = numeCuloare;
    }

    public double getPretCuloare() {
        return pretCuloare;
    }

    public void setPretCuloare(double pretCuloare) {
        this.pretCuloare = pretCuloare;
    }

    public String getTipFinisaj() {
        return tipFinisaj;
    }

    public void setTipFinisaj(String tipFinisaj) {
        this.tipFinisaj = tipFinisaj;
    }

    @Override
    public String toString() {
        return "Culoare{" +
                "idCuloare=" + ID_CULOARE +
                ", numeCuloare='" + numeCuloare + '\'' +
                ", pretCuloare=" + pretCuloare +
                ", tipFinisaj='" + tipFinisaj + '\'' +
                '}';
    }
}
