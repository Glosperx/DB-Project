package com.example.BD.Comanda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comanda")
public class Comanda_Controller {

    private final Comanda_Repository comandaRepository;
    private final Comanda_Service comandaService;

    @Autowired
    public Comanda_Controller(Comanda_Repository comandaRepository, Comanda_Service comandaService) {
        this.comandaRepository = comandaRepository;
        this.comandaService = comandaService;
    }

    @GetMapping
    public List<Comanda> getAllComenzi() {
        return comandaRepository.findAll();
    }

    @GetMapping("/{id}/pretTotal")
    public Double getPretTotal(@PathVariable Long id) {
        return comandaService.getPretTotal(id);
    }

    @GetMapping("/MetodaPlataAsc")
    public List<Comanda> sortByMetodaPlataAsc() {
        return comandaRepository.sortByMetodaPlataAsc();
    }

    @GetMapping("/MetodaPlataDesc")
    public List<Comanda> sortByMetodaPlataDesc() {
        return comandaRepository.sortByMetodaPlataDesc();
    }

    @GetMapping("/OrasLivrareAsc")
    public List<Comanda> sortByOrasLivrareAsc() {
        return comandaRepository.sortByOrasLivrareAsc();
    }

    @GetMapping("/OrasLivrareDesc")
    public List<Comanda> sortByOrasLivrareDesc() {
        return comandaRepository.sortByOrasLivrareDesc();
    }

    @GetMapping("/IdClientAsc")
    public List<Comanda> sortByIdClientAsc() {
        return comandaRepository.sortByIdClientAsc();
    }

    @GetMapping("/IdClientDesc")
    public List<Comanda> sortByIdClientDesc() {
        return comandaRepository.sortByIdClientDesc();
    }

    @PostMapping("/add")
    public Comanda addComanda(@RequestBody Comanda comanda) {
        return comandaRepository.save(comanda);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteComanda(@PathVariable Long id) {
        if (comandaRepository.existsById(id)) {
            comandaRepository.deleteById(id);
            return "Comanda cu ID " + id + " a fost stearsa.";
        } else {
            return "Comanda cu ID " + id + " nu exista.";
        }
    }

    @PutMapping("/update/{id}")
    public Comanda updateComanda(@PathVariable Long id, @RequestBody Comanda comandaDetails) {
        return comandaRepository.findById(id).map(comanda -> {
            comanda.setMetodaPlata(comandaDetails.getMetodaPlata());
            comanda.setOrasLivrare(comandaDetails.getOrasLivrare());
            comanda.setClient(comandaDetails.getClient());
            comanda.setMotor(comandaDetails.getMotor());
            comanda.setPachet(comandaDetails.getPachet());
            comanda.setCuloare(comandaDetails.getCuloare());
            comanda.setRoti(comandaDetails.getRoti());
            return comandaRepository.save(comanda);
        }).orElseThrow(() -> new RuntimeException("Comanda cu ID " + id + " nu exista."));
    }

    @GetMapping("/{comandaId}/pret-total")
    public ResponseEntity<Double> getTotalPrice(@PathVariable Long comandaId) {
        double totalPrice =  comandaRepository.calculPretTotal(2l);
        return ResponseEntity.ok(totalPrice);


    }
}
