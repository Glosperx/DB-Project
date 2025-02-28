package com.example.BD.Pachet_Echipare;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "PACHET_ECHIPARE")
public class Pachet_Echipare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_pachet")
    private int ID_Pachet;

    @JsonProperty("nume_pachet")
    @Column(name = "Nume_Pachet", nullable = false, unique = true)
    private String numePachet;

    @JsonProperty("pret_pachet")
    @Column(name = "Pret_Pachet", nullable = false)
    private double pretPachet;

    public Pachet_Echipare() {}

    public Pachet_Echipare(String numePachet, double pretPachet) {
        this.numePachet = numePachet;
        this.pretPachet = pretPachet;
    }

    public int getIdPachet() {
        return ID_Pachet;
    }

    public void setIdPachet(int idPachet) {
        this.ID_Pachet = idPachet;
    }

    public String getNumePachet() {
        return numePachet;
    }

    public void setNumePachet(String numePachet) {
        this.numePachet = numePachet;
    }

    public double getPretPachet() {
        return pretPachet;
    }

    public void setPretPachet(double pretPachet) {
        this.pretPachet = pretPachet;
    }

    @Override
    public String toString() {
        return "PachetEchipare{" +
                "idPachet=" + ID_Pachet +
                ", numePachet='" + numePachet + '\'' +
                ", pretPachet=" + pretPachet +
                '}';
    }
}
