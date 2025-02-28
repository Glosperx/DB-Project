package com.example.BD.Comanda;

import com.example.BD.Comanda.Comanda_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class Comanda_Service {

    private final Comanda_Repository comandaRepository;

    @Autowired
    public Comanda_Service(Comanda_Repository comandaRepository) {
        this.comandaRepository = comandaRepository;
    }

    public List<Comanda> getAllComenzi() {
        return comandaRepository.findAll();
    }

    public List<Comanda> sortByMetodaPlataAsc() {
        return comandaRepository.sortByMetodaPlataAsc();
    }

    public List<Comanda> sortByMetodaPlataDesc() {
        return comandaRepository.sortByMetodaPlataDesc();
    }

    public List<Comanda> sortByOrasLivrareAsc() {
        return comandaRepository.sortByOrasLivrareAsc();
    }

    public List<Comanda> sortByOrasLivrareDesc() {
        return comandaRepository.sortByOrasLivrareDesc();
    }

    public List<Comanda> sortByIdClientAsc() {
        return comandaRepository.sortByIdClientAsc();
    }

    public List<Comanda> sortByIdClientDesc() {
        return comandaRepository.sortByIdClientDesc();
    }

    public Double getPretTotal(Long comandaId) {
        return comandaRepository.calculPretTotal(comandaId);
    }

    public void deleteByIdComanda(Long idComanda) {
        comandaRepository.deleteByIdComanda(idComanda);
    }

    @Transactional
    public void updateComanda(Long idComanda, char metodaPlata, String orasLivrare) {
        Optional<Comanda> comandaOptional = comandaRepository.findById(idComanda);
        if (comandaOptional.isEmpty()) {
            throw new IllegalArgumentException("Comanda cu ID-ul " + idComanda + " nu a fost gasita.");
        }

        Comanda comanda = comandaOptional.get();
        comanda.setMetodaPlata(metodaPlata);
        comanda.setOrasLivrare(orasLivrare);

        comandaRepository.save(comanda);
    }
}
