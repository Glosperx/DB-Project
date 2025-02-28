package com.example.BD.Comenzi_Pachet;

import com.example.BD.Comanda.Comanda;
import com.example.BD.Pachet_Echipare.Pachet_Echipare;
import jakarta.persistence.*;

@Entity
@Table(name = "COMENZI_PACHET")
public class Comenzi_Pachet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMANDA_PACHET")
    private Long idComandaPachet;

    @ManyToOne
    @JoinColumn(name = "ID_Comanda", referencedColumnName = "ID_Comanda", nullable = false)
    private Comanda comanda;

    @ManyToOne
    @JoinColumn(name = "ID_Pachet", referencedColumnName = "ID_Pachet", nullable = false)
    private Pachet_Echipare pachetEchipare;

    @Column(name = "Reducere", nullable = false)
    private Double reducere;

    public Comenzi_Pachet() {}

    public Comenzi_Pachet(Comanda comanda, Pachet_Echipare pachetEchipare, Double reducere) {
        this.comanda = comanda;
        this.pachetEchipare = pachetEchipare;
        this.reducere = reducere != null ? reducere : 0.0;
    }

    // Getteri și setteri pentru toate atributele

    public Long getIdComandaPachet() {
        return idComandaPachet;
    }

    public void setIdComandaPachet(Long idComandaPachet) {
        this.idComandaPachet = idComandaPachet;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public Pachet_Echipare getPachetEchipare() {
        return pachetEchipare;
    }

    public void setPachetEchipare(Pachet_Echipare pachetEchipare) {
        this.pachetEchipare = pachetEchipare;
    }

    public Double getReducere() {
        return reducere;
    }

    public void setReducere(Double reducere) {
        this.reducere = reducere;
    }

    @Override
    public String toString() {
        return "Comenzi_Pachet{" +
                "idComandaPachet=" + idComandaPachet +
                ", comanda=" + comanda.getIdComanda() +
                ", pachetEchipare=" + pachetEchipare.getIdPachet() +
                ", reducere=" + reducere +
                '}';
    }
}
