package com.example.BD.Culoare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/culoare")
public class Culoare_Controller {

    private final Culoare_Repository culoareRepository;

    @Autowired
    public Culoare_Controller(Culoare_Repository culoareRepository) {
        this.culoareRepository = culoareRepository;
    }

    @GetMapping
    public List<Culoare> getAllCulori() {
        return culoareRepository.findAll();
    }

    @GetMapping("/IdAsc")
    public List<Culoare> sortById() {
        return culoareRepository.sortById();
    }

    @GetMapping("/IdDesc")
    public List<Culoare> sortByIdDesc() {
        return culoareRepository.sortDById();
    }

    @GetMapping("/NumeCuloareAsc")
    public List<Culoare> sortByNumeCuloare() {
        return culoareRepository.sortByNumeCuloare();
    }

    @GetMapping("/NumeCuloareDesc")
    public List<Culoare> sortByNumeCuloareDesc() {
        return culoareRepository.sortDByNumeCuloare();
    }

    @GetMapping("/PretCuloareAsc")
    public List<Culoare> sortByPretCuloare() {
        return culoareRepository.sortByPretCuloare();
    }

    @GetMapping("/PretCuloareDesc")
    public List<Culoare> sortByPretCuloareDesc() {
        return culoareRepository.sortDByPretCuloare();
    }

    @GetMapping("/findByTipFinisaj/{tipFinisaj}")
    public List<Culoare> findByTipFinisaj(@PathVariable String tipFinisaj) {
        return culoareRepository.findByTipFinisaj(tipFinisaj);
    }

    // Adaugă o noua culoare
    @PostMapping("/add")
    public Culoare addCuloare(@RequestBody Culoare culoare) {
        return culoareRepository.save(culoare);
    }

    // Sterge o culoare dupa ID
    @DeleteMapping("/delete/{id}")
    public String deleteCuloare(@PathVariable Integer id) {
        if (culoareRepository.existsById(id)) {
            culoareRepository.deleteById(id);
            return "Culoarea cu ID " + id + " a fost stearsa.";
        } else {
            return "Culoarea cu ID " + id + " nu exista.";
        }
    }

    // Actualizeaza o culoare existenta
    @PutMapping("/update/{id}")
    public Culoare updateCuloare(@PathVariable Integer id, @RequestBody Culoare culoareDetails) {
        return culoareRepository.findById(id).map(culoare -> {
            culoare.setNumeCuloare(culoareDetails.getNumeCuloare());
            culoare.setPretCuloare(culoareDetails.getPretCuloare());
            culoare.setTipFinisaj(culoareDetails.getTipFinisaj());
            return culoareRepository.save(culoare);
        }).orElseThrow(() -> new RuntimeException("Culoarea cu ID " + id + " nu exista."));
    }
}
