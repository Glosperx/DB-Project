package com.example.BD.Kart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kart")
public class Kart_Controller {

    private final Kart_Repository kartRepository;

    @Autowired
    public Kart_Controller(Kart_Repository kartRepository) {
        this.kartRepository = kartRepository;
    }

    @GetMapping
    public List<Kart> getAllKarturi() {
        return kartRepository.findAll();
    }

    @GetMapping("/NumeModelAsc")
    public List<Kart> sortByNumeModelAsc() {
        return kartRepository.sortByNumeModelAsc();
    }

    @GetMapping("/NumeModelDesc")
    public List<Kart> sortByNumeModelDesc() {
        return kartRepository.sortByNumeModelDesc();
    }

    @GetMapping("/PretBazaAsc")
    public List<Kart> sortByPretBazaAsc() {
        return kartRepository.sortByPretBazaAsc();
    }

    @GetMapping("/PretBazaDesc")
    public List<Kart> sortByPretBazaDesc() {
        return kartRepository.sortByPretBazaDesc();
    }

    @GetMapping("/GreutateAsc")
    public List<Kart> sortByGreutateAsc() {
        return kartRepository.sortByGreutateAsc();
    }

    @GetMapping("/GreutateDesc")
    public List<Kart> sortByGreutateDesc() {
        return kartRepository.sortByGreutateDesc();
    }

    @PostMapping("/add")
    public Kart addKart(@RequestBody Kart kart) {
        return kartRepository.save(kart);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteKart(@PathVariable Integer id) {
        if (kartRepository.existsById(id)) {
            kartRepository.deleteById(id);
            return "Kart cu ID " + id + " a fost sters.";
        } else {
            return "Kart cu ID " + id + " nu exista.";
        }
    }

    @PutMapping("/update/{id}")
    public Kart updateKart(@PathVariable Integer id, @RequestBody Kart kartDetails) {
        return kartRepository.findById(id).map(kart -> {
            kart.setPretBaza(kartDetails.getPretBaza());
            kart.setNumeModel(kartDetails.getNumeModel());
            kart.setGreutate(kartDetails.getGreutate());
            kart.setMotor(kartDetails.getMotor());
            kart.setCuloare(kartDetails.getCuloare());
            kart.setRoti(kartDetails.getRoti());
            kart.setPachetEchipare(kartDetails.getPachetEchipare());
            return kartRepository.save(kart);
        }).orElseThrow(() -> new RuntimeException("Kart cu ID " + id + " nu exista."));
    }
}
