package com.example.BD.Client;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id_client")
    private int ID_Client;

    @JsonProperty("nume")
    @Column(name = "Nume", nullable = false)
    private String nume;

    @JsonProperty("prenume")
    @Column(name = "Prenume", nullable = false)
    private String prenume;

    @JsonProperty("email")
    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @JsonProperty("telefon")
    @Column(name = "Telefon", nullable = false)
    private String telefon;

    @JsonProperty("tara_provenienta")
    @Column(name = "Tara_provenienta", nullable = false)
    private String taraProvenienta;

    public Client() {}

    public Client(String nume, String prenume, String email, String telefon, String taraProvenienta) {
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.telefon = telefon;
        this.taraProvenienta = taraProvenienta;
    }

    public int getIdClient() {
        return ID_Client;
    }

    public void setIdClient(int idClient) {
        this.ID_Client = idClient;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getTaraProvenienta() {
        return taraProvenienta;
    }

    public void setTaraProvenienta(String taraProvenienta) {
        this.taraProvenienta = taraProvenienta;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + ID_Client +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", email='" + email + '\'' +
                ", telefon='" + telefon + '\'' +
                ", taraProvenienta='" + taraProvenienta + '\'' +
                '}';
    }
}
