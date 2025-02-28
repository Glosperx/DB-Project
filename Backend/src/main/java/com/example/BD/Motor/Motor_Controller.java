package com.example.BD.Motor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motor")
public class Motor_Controller {

    private final Motor_Repository motorRepository;

    @Autowired
    public Motor_Controller(Motor_Repository motorRepository) {
        this.motorRepository = motorRepository;
    }

    @GetMapping
    public List<Motor> getAllMotors() {
        return motorRepository.findAll();
    }

    @GetMapping("/IdAsc")
    public List<Motor> sortById() {
        return motorRepository.sortById();
    }

    @GetMapping("/IdDesc")
    public List<Motor> sortByIdDesc() {
        return motorRepository.sortDById();
    }

    @GetMapping("/TipMotorAsc")
    public List<Motor> sortByTipMotor() {
        return motorRepository.sortByTipMotor();
    }

    @GetMapping("/TipMotorDesc")
    public List<Motor> sortByTipMotorDesc() {
        return motorRepository.sortDByTipMotor();
    }

    @PostMapping("/add")
    public Motor addMotor(@RequestBody Motor motor) {
        return motorRepository.save(motor);
    }

    // Sterge un motor dupa ID
    @DeleteMapping("/delete/{id}")
    public String deleteMotor(@PathVariable Integer id) {
        if (motorRepository.existsById(id)) {
            motorRepository.deleteById(id);
            return "Motorul cu ID " + id + " a fost sters.";
        } else {
            return "Motorul cu ID " + id + " nu exista.";
        }
    }

    // Actualizează un motor existent
    @PutMapping("/update/{id}")
    public Motor updateMotor(@PathVariable Integer id, @RequestBody Motor motorDetails) {
        return motorRepository.findById(id).map(motor -> {
            motor.setTipMotor(motorDetails.getTipMotor());
            motor.setCapacitateCilindrica(motorDetails.getCapacitateCilindrica());
            motor.setPutere(motorDetails.getPutere());
            motor.setPretMotor(motorDetails.getPretMotor());
            return motorRepository.save(motor);
        }).orElseThrow(() -> new RuntimeException("Motorul cu ID " + id + " nu exista."));
    }
}
