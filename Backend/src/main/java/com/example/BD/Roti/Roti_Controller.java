package com.example.BD.Roti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roti")
public class Roti_Controller {

    private final Roti_Repository rotiRepository;

    @Autowired
    public Roti_Controller(Roti_Repository rotiRepository) {
        this.rotiRepository = rotiRepository;
    }

    @GetMapping("/all")
    public List<Roti> getAllRoti() {
        return rotiRepository.findAll();
    }

    @GetMapping("/sortById")
    public List<Roti> sortById() {
        return rotiRepository.sortById();
    }

    @GetMapping("/sortByIdDesc")
    public List<Roti> sortByIdDesc() {
        return rotiRepository.sortDById();
    }

    @GetMapping("/sortByDimensiuneRoti")
    public List<Roti> sortByDimensiuneRoti() {
        return rotiRepository.sortByDimensiuneRoti();
    }

    @GetMapping("/sortByDimensiuneRotiDesc")
    public List<Roti> sortByDimensiuneRotiDesc() {
        return rotiRepository.sortDByDimensiuneRoti();
    }

    @GetMapping("/sortByCuloareRoti")
    public List<Roti> sortByCuloareRoti() {
        return rotiRepository.sortByCuloareRoti();
    }

    @GetMapping("/sortByCuloareRotiDesc")
    public List<Roti> sortByCuloareRotiDesc() {
        return rotiRepository.sortDByCuloareRoti();
    }

    @GetMapping("/sortByDenumireRoti")
    public List<Roti> sortByDenumireRoti() {
        return rotiRepository.sortByDenumireRoti();
    }

    @GetMapping("/sortByDenumireRotiDesc")
    public List<Roti> sortByDenumireRotiDesc() {
        return rotiRepository.sortDByDenumireRoti();
    }

    @GetMapping("/sortByPretRoti")
    public List<Roti> sortByPretRoti() {
        return rotiRepository.sortByPretRoti();
    }

    @GetMapping("/sortByPretRotiDesc")
    public List<Roti> sortByPretRotiDesc() {
        return rotiRepository.sortDByPretRoti();
    }

    @PostMapping("/add")
    public Roti addRoti(@RequestBody Roti roti) {
        return rotiRepository.save(roti);
    }

    // Sterge o Roata dupa ID
    @DeleteMapping("/delete/{id}")
    public String deleteRoti(@PathVariable Integer id) {
        if (rotiRepository.existsById(id)) {
            rotiRepository.deleteById(id);
            return "Roata cu ID " + id + " a fost ștearsa.";
        } else {
            return "Roata cu ID " + id + " nu exista.";
        }
    }

    // Actualizează o Roata existenta
    @PutMapping("/update/{id}")
    public Roti updateRoti(@PathVariable Integer id, @RequestBody Roti rotiDetails) {
        return rotiRepository.findById(id).map(roti -> {
            roti.setDimensiuneRoti(rotiDetails.getDimensiuneRoti());
            roti.setCuloareRoti(rotiDetails.getCuloareRoti());
            roti.setDenumireRoti(rotiDetails.getDenumireRoti());
            roti.setPretRoti(rotiDetails.getPretRoti());
            return rotiRepository.save(roti);
        }).orElseThrow(() -> new RuntimeException("Roata cu ID " + id + " nu exista."));
    }
}
