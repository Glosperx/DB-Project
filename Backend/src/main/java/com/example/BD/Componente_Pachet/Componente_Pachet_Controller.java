package com.example.BD.Componente_Pachet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/componente_pachet")
public class Componente_Pachet_Controller {

    private final Componente_Pachet_Repository componentePachetRepository;

    @Autowired
    public Componente_Pachet_Controller(Componente_Pachet_Repository componentePachetRepository) {
        this.componentePachetRepository = componentePachetRepository;
    }

    @GetMapping
    public List<Componente_Pachet> getAllComponentePachet() {
        return componentePachetRepository.findAll();
    }

    @GetMapping("/PachetAsc")
    public List<Componente_Pachet> sortByPachetAsc() {
        return componentePachetRepository.sortByPachetAsc();
    }

    @GetMapping("/PachetDesc")
    public List<Componente_Pachet> sortByPachetDesc() {
        return componentePachetRepository.sortByPachetDesc();
    }

    @GetMapping("/ElementAsc")
    public List<Componente_Pachet> sortByElementAsc() {
        return componentePachetRepository.sortByElementAsc();
    }

    @GetMapping("/ElementDesc")
    public List<Componente_Pachet> sortByElementDesc() {
        return componentePachetRepository.sortByElementDesc();
    }

    @GetMapping("/InclusAsc")
    public List<Componente_Pachet> sortByInclusAsc() {
        return componentePachetRepository.sortByInclusAsc();
    }

    @GetMapping("/InclusDesc")
    public List<Componente_Pachet> sortByInclusDesc() {
        return componentePachetRepository.sortByInclusDesc();
    }

    @PostMapping("/add")
    public Componente_Pachet addComponentePachet(@RequestBody Componente_Pachet componentePachet) {
        return componentePachetRepository.save(componentePachet);
    }

    @DeleteMapping("/delete")
    public String deleteComponentePachet(@RequestBody Componente_Pachet componentePachet) {
        componentePachetRepository.delete(componentePachet);
        return "Componente Pachet a fost sters.";
    }

    @PutMapping("/update")
    public Componente_Pachet updateComponentePachet(@RequestBody Componente_Pachet componentePachet) {
        return componentePachetRepository.save(componentePachet);
    }
}
