package com.example.BD.Pachet_Echipare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Pachet_Echipare")
public class Pachet_Echipare_Controller {

    private final Pachet_Echipare_Repository Pachet_EchipareRepository;

    @Autowired
    public Pachet_Echipare_Controller(Pachet_Echipare_Repository Pachet_EchipareRepository) {
        this.Pachet_EchipareRepository = Pachet_EchipareRepository;
    }

    @GetMapping
    public List<Pachet_Echipare> getAllPachet_Echipare() {
        return Pachet_EchipareRepository.findAll();
    }

    @GetMapping("/IdAsc")
    public List<Pachet_Echipare> sortById() {
        return Pachet_EchipareRepository.sortById();
    }

    @GetMapping("/IdDesc")
    public List<Pachet_Echipare> sortByIdDesc() {
        return Pachet_EchipareRepository.sortDById();
    }

    @GetMapping("/NumePachetAsc")
    public List<Pachet_Echipare> sortByNumePachet() {
        return Pachet_EchipareRepository.sortByNumePachet();
    }

    @GetMapping("/NumePachetDesc")
    public List<Pachet_Echipare> sortByNumePachetDesc() {
        return Pachet_EchipareRepository.sortDByNumePachet();
    }

    @GetMapping("/PretPachetAsc")
    public List<Pachet_Echipare> sortByPretPachet() {
        return Pachet_EchipareRepository.sortByPretPachet();
    }

    @GetMapping("/PretPachetDesc")
    public List<Pachet_Echipare> sortByPretPachetDesc() {
        return Pachet_EchipareRepository.sortDByPretPachet();
    }

    @PostMapping("/add")
    public Pachet_Echipare addPachet_Echipare(@RequestBody Pachet_Echipare Pachet_Echipare) {
        return Pachet_EchipareRepository.save(Pachet_Echipare);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePachet_Echipare(@PathVariable Integer id) {
        if (Pachet_EchipareRepository.existsById(id)) {
            Pachet_EchipareRepository.deleteById(id);
            return "Pachetul cu ID " + id + " a fost sters.";
        } else {
            return "Pachetul cu ID " + id + " nu exista.";
        }
    }

    @PutMapping("/update/{id}")
    public Pachet_Echipare updatePachet_Echipare(@PathVariable Integer id, @RequestBody Pachet_Echipare Pachet_EchipareDetails) {
        return Pachet_EchipareRepository.findById(id).map(Pachet_Echipare -> {
            Pachet_Echipare.setNumePachet(Pachet_EchipareDetails.getNumePachet());
            Pachet_Echipare.setPretPachet(Pachet_EchipareDetails.getPretPachet());
            return Pachet_EchipareRepository.save(Pachet_Echipare);
        }).orElseThrow(() -> new RuntimeException("Pachetul cu ID " + id + " nu exista."));
    }
}
