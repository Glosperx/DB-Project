package com.example.BD.Kart;

import com.example.BD.Motor.Motor;
import com.example.BD.Culoare.Culoare;
import com.example.BD.Roti.Roti;
import com.example.BD.Pachet_Echipare.Pachet_Echipare;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity // Maps this class to the KART table in the database
@Table(name = "KART")
public class Kart {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    @Column(name = "ID_Kart") // Maps to the ID_Kart column in the database
    private Integer ID_Kart;

    @Column(name = "Pret_Baza", nullable = false) // Maps to the Pret_Baza column
    private Double pretBaza;

    @Column(name = "Nume_Model", nullable = false, unique = true) // Maps to the Nume_Model column
    private String numeModel;

    @Column(name = "Greutate", nullable = false) // Maps to the Greutate column
    private Double greutate;

    @ManyToOne // Many-to-One relationship with Motor
    @JoinColumn(name = "ID_Motor", referencedColumnName = "ID_Motor")
    @JsonIgnoreProperties("karts") // Prevents serialization of karts in Motor
    private Motor motor;

    @ManyToOne // Many-to-One relationship with Culoare
    @JoinColumn(name = "ID_Culoare", referencedColumnName = "ID_Culoare")
    @JsonIgnoreProperties("karts") // Prevents serialization of karts in Culoare
    private Culoare culoare;

    @ManyToOne // Many-to-One relationship with Roti
    @JoinColumn(name = "ID_Roti", referencedColumnName = "ID_Roti")
    @JsonIgnoreProperties("karts") // Prevents serialization of karts in Roti
    private Roti roti;

    @ManyToOne // Many-to-One relationship with Pachet_Echipare
    @JoinColumn(name = "ID_Pachet", referencedColumnName = "ID_Pachet", nullable = true)
    @JsonIgnoreProperties("karts") // Prevents serialization of karts in Pachet_Echipare
    private Pachet_Echipare pachetEchipare;

    // Default constructor (required by JPA)
    public Kart() {}

    // Constructor for easy object creation
    public Kart(Double pretBaza, String numeModel, Double greutate, Motor motor, Culoare culoare, Roti roti, Pachet_Echipare pachetEchipare) {
        this.pretBaza = pretBaza;
        this.numeModel = numeModel;
        this.greutate = greutate;
        this.motor = motor;
        this.culoare = culoare;
        this.roti = roti;
        this.pachetEchipare = pachetEchipare;
    }

    // Getters and setters
    public Integer getIdKart() {
        return ID_Kart;
    }

    public void setIdKart(Integer idKart) {
        this.ID_Kart = idKart;
    }

    public Double getPretBaza() {
        return pretBaza;
    }

    public void setPretBaza(Double pretBaza) {
        this.pretBaza = pretBaza;
    }

    public String getNumeModel() {
        return numeModel;
    }

    public void setNumeModel(String numeModel) {
        this.numeModel = numeModel;
    }

    public Double getGreutate() {
        return greutate;
    }

    public void setGreutate(Double greutate) {
        this.greutate = greutate;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Culoare getCuloare() {
        return culoare;
    }

    public void setCuloare(Culoare culoare) {
        this.culoare = culoare;
    }

    public Roti getRoti() {
        return roti;
    }

    public void setRoti(Roti roti) {
        this.roti = roti;
    }

    public Pachet_Echipare getPachetEchipare() {
        return pachetEchipare;
    }

    public void setPachetEchipare(Pachet_Echipare pachetEchipare) {
        this.pachetEchipare = pachetEchipare;
    }

    @Override
    public String toString() {
        return "Kart{" +
                "idKart=" + ID_Kart +
                ", pretBaza=" + pretBaza +
                ", numeModel='" + numeModel + '\'' +
                ", greutate=" + greutate +
                ", motor=" + (motor != null ? motor.getIdMotor() : "None") +
                ", culoare=" + (culoare != null ? culoare.getIdCuloare() : "None") +
                ", roti=" + (roti != null ? roti.getIdRoti() : "None") +
                ", pachetEchipare=" + (pachetEchipare != null ? pachetEchipare.getIdPachet() : "None") +
                '}';
    }
}