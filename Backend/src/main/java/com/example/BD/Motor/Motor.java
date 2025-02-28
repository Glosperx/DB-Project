package com.example.BD.Motor;

import com.example.BD.Kart.Kart;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.List;

@Entity // Maps this class to the MOTOR table in the database
@Table(name = "MOTOR")
public class Motor {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    @JsonProperty("id_motor") // Maps to "id_motor" in JSON
    private int ID_Motor;

    @JsonProperty("tip_motor") // Maps to "tip_motor" in JSON
    private String tipMotor;

    @JsonProperty("capacitate_cilindrica") // Maps to "capacitate_cilindrica" in JSON
    private int capacitateCilindrica;

    @JsonProperty("putere") // Maps to "putere" in JSON
    private double putere;

    @JsonProperty("pret_motor") // Maps to "pret_motor" in JSON
    private double pretMotor;

    @OneToMany(mappedBy = "motor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // Prevents serialization of karts
    private List<Kart> karts;

    // Default constructor (required by JPA)
    public Motor() {}

    // Constructor for easy object creation
    public Motor(String tipMotor, int capacitateCilindrica, double putere, double pretMotor) {
        this.tipMotor = tipMotor;
        this.capacitateCilindrica = capacitateCilindrica;
        this.putere = putere;
        this.pretMotor = pretMotor;
    }

    // Getters and setters
    public int getIdMotor() {
        return ID_Motor;
    }

    public void setIdMotor(int idMotor) {
        this.ID_Motor = idMotor;
    }

    public String getTipMotor() {
        return tipMotor;
    }

    public void setTipMotor(String tipMotor) {
        this.tipMotor = tipMotor;
    }

    public int getCapacitateCilindrica() {
        return capacitateCilindrica;
    }

    public void setCapacitateCilindrica(int capacitateCilindrica) {
        this.capacitateCilindrica = capacitateCilindrica;
    }

    public double getPutere() {
        return putere;
    }

    public void setPutere(double putere) {
        this.putere = putere;
    }

    public double getPretMotor() {
        return pretMotor;
    }

    public void setPretMotor(double pretMotor) {
        this.pretMotor = pretMotor;
    }

    public List<Kart> getKarts() {
        return karts;
    }

    public void setKarts(List<Kart> karts) {
        this.karts = karts;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "idMotor=" + ID_Motor +
                ", tipMotor='" + tipMotor + '\'' +
                ", capacitateCilindrica=" + capacitateCilindrica +
                ", putere=" + putere +
                ", pretMotor=" + pretMotor +
                '}';
    }
}