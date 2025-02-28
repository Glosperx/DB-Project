package com.example.BD.Componente_Pachet;

import com.example.BD.Elemente_Pachet.Elemente_Pachet;
import com.example.BD.Pachet_Echipare.Pachet_Echipare;
import jakarta.persistence.*;

@Entity
@Table(name = "COMPONENTE_PACHET")
public class Componente_Pachet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMPONENTA_PACHET")
    private Long idComponentePachet; // Cheia primară generată automat

    @Column(name = "ID_Pachet", nullable = false)
    private Long idPachet; // ID-ul Pachet_Echipare

    @Column(name = "ID_Element", nullable = false)
    private Long idElement; // ID-ul Elemente_Pachet

    @Column(name = "Inclus", nullable = false)
    private boolean inclus;

    public Componente_Pachet() {}

    public Componente_Pachet(Long idPachet, Long idElement, boolean inclus) {
        this.idPachet = idPachet;
        this.idElement = idElement;
        this.inclus = inclus;
    }

    public Long getIdComponentePachet() {
        return idComponentePachet;
    }

    public void setIdComponentePachet(Long idComponentePachet) {
        this.idComponentePachet = idComponentePachet;
    }

    public Long getIdPachet() {
        return idPachet;
    }

    public void setIdPachet(Long idPachet) {
        this.idPachet = idPachet;
    }

    public Long getIdElement() {
        return idElement;
    }

    public void setIdElement(Long idElement) {
        this.idElement = idElement;
    }

    public boolean isInclus() {
        return inclus;
    }

    public void setInclus(boolean inclus) {
        this.inclus = inclus;
    }

    @Override
    public String toString() {
        return "Componente_Pachet{" +
                "idComponentePachet=" + idComponentePachet +
                ", idPachet=" + idPachet +
                ", idElement=" + idElement +
                ", inclus=" + inclus +
                '}';
    }
}
