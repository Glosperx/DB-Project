package com.example.BD.Comanda;

import com.example.BD.Client.Client;
import com.example.BD.Comenzi_Pachet.Comenzi_Pachet;
import com.example.BD.Motor.Motor;
import com.example.BD.Pachet_Echipare.Pachet_Echipare;
import com.example.BD.Culoare.Culoare;
import com.example.BD.Roti.Roti;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "COMANDA")
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Comanda")
    private Long ID_Comanda;

    @Column(name = "Metoda_Plata", nullable = false)
    private char metodaPlata;

    @Column(name = "Oras_Livrare", nullable = false)
    private String orasLivrare;

    @OneToMany(mappedBy = "comanda")
    private List<Comenzi_Pachet> comenziPachet;

    @ManyToOne
    @JoinColumn(name = "ID_Client", referencedColumnName = "ID_Client", nullable = false)
    @JsonIgnore
    private Client client;

    @ManyToOne
    @JoinColumn(name = "ID_Motor", referencedColumnName = "ID_Motor", nullable = false)
    private Motor motor;

    @ManyToOne
    @JoinColumn(name = "ID_Pachet", referencedColumnName = "ID_Pachet", nullable = false)
    private Pachet_Echipare pachet;

    @ManyToOne
    @JoinColumn(name = "ID_Culoare", referencedColumnName = "ID_Culoare", nullable = false)
    private Culoare culoare;

    @ManyToOne
    @JoinColumn(name = "ID_Roti", referencedColumnName = "ID_Roti", nullable = false)
    private Roti roti;

    @Transient
    private Double pretTotal;

    // Constructori, getteri și setteri

    public Long getIdComanda() {
        return ID_Comanda;
    }

    public void setIdComanda(Long idComanda) {
        this.ID_Comanda = idComanda;
    }

    public char getMetodaPlata() {
        return metodaPlata;
    }

    public void setMetodaPlata(char metodaPlata) {
        this.metodaPlata = metodaPlata;
    }

    public String getOrasLivrare() {
        return orasLivrare;
    }

    public void setOrasLivrare(String orasLivrare) {
        this.orasLivrare = orasLivrare;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Pachet_Echipare getPachet() {
        return pachet;
    }

    public void setPachet(Pachet_Echipare pachet) {
        this.pachet = pachet;
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

    public Double getPretTotal() {
        return pretTotal;
    }

    public void setPretTotal(Double pretTotal) {
        this.pretTotal = pretTotal;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "idComanda=" + ID_Comanda +
                ", metodaPlata=" + metodaPlata +
                ", orasLivrare='" + orasLivrare + '\'' +
                ", client=" + client.getIdClient() +
                ", pretTotal=" + pretTotal +
                '}';
    }
}
