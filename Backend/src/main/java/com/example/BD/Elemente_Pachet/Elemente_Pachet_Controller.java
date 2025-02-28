package com.example.BD.Elemente_Pachet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Elemente_Pachet")
public class Elemente_Pachet_Controller {

    private final Elemente_Pachet_Repository Elemente_PachetRepository;

    @Autowired
    public Elemente_Pachet_Controller(Elemente_Pachet_Repository Elemente_PachetRepository) {
        this.Elemente_PachetRepository = Elemente_PachetRepository;
    }

    @GetMapping
    public List<Elemente_Pachet> getAllElemente_Pachet() {
        return Elemente_PachetRepository.findAll();
    }

    @GetMapping("/IdAsc")
    public List<Elemente_Pachet> sortById() {
        return Elemente_PachetRepository.sortById();
    }

    @GetMapping("/IdDesc")
    public List<Elemente_Pachet> sortByIdDesc() {
        return Elemente_PachetRepository.sortDById();
    }

    @GetMapping("/NumeElementAsc")
    public List<Elemente_Pachet> sortByNumeElement() {
        return Elemente_PachetRepository.sortByNumeElement();
    }

    @GetMapping("/NumeElementDesc")
    public List<Elemente_Pachet> sortByNumeElementDesc() {
        return Elemente_PachetRepository.sortDByNumeElement();
    }

    @GetMapping("/MaterialAsc")
    public List<Elemente_Pachet> sortByMaterial() {
        return Elemente_PachetRepository.sortByMaterial();
    }

    @GetMapping("/MaterialDesc")
    public List<Elemente_Pachet> sortByMaterialDesc() {
        return Elemente_PachetRepository.sortDByMaterial();
    }

    @PostMapping("/add")
    public Elemente_Pachet addElemente_Pachet(@RequestBody Elemente_Pachet Elemente_Pachet) {
        return Elemente_PachetRepository.save(Elemente_Pachet);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteElemente_Pachet(@PathVariable Integer id) {
        if (Elemente_PachetRepository.existsById(id)) {
            Elemente_PachetRepository.deleteById(id);
            return "Elementul cu ID " + id + " a fost sters.";
        } else {
            return "Elementul cu ID " + id + " nu exista.";
        }
    }

    @PutMapping("/update/{id}")
    public Elemente_Pachet updateElemente_Pachet(@PathVariable Integer id, @RequestBody Elemente_Pachet Elemente_PachetDetails) {
        return Elemente_PachetRepository.findById(id).map(Elemente_Pachet -> {
            Elemente_Pachet.setNumeElement(Elemente_PachetDetails.getNumeElement());
            Elemente_Pachet.setMaterial(Elemente_PachetDetails.getMaterial());
            return Elemente_PachetRepository.save(Elemente_Pachet);
        }).orElseThrow(() -> new RuntimeException("Elementul cu ID " + id + " nu exista."));
    }
}
