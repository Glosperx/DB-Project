package com.example.BD.Elemente_Pachet;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "ELEMENTE_PACHET")
public class Elemente_Pachet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_element")
    private int ID_ELEMENT;

    @JsonProperty("nume_element")
    @Column(name = "Nume_Element", nullable = false, unique = true)
    private String numeElement;

    @JsonProperty("material")
    @Column(name = "Material")
    private String material;

    public Elemente_Pachet() {}

    public Elemente_Pachet(String numeElement, String material) {
        this.numeElement = numeElement;
        this.material = material;
    }

    public int getIdElement() {
        return ID_ELEMENT;
    }

    public void setIdElement(int ID_ELEMENT) {
        this.ID_ELEMENT = ID_ELEMENT;
    }

    public String getNumeElement() {
        return numeElement;
    }

    public void setNumeElement(String numeElement) {
        this.numeElement = numeElement;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Elemente_Pachet{" +
                "ID_ELEMENT=" + ID_ELEMENT +
                ", numeElement='" + numeElement + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
