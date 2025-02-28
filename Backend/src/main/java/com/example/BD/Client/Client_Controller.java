package com.example.BD.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class Client_Controller {

    private final Client_Repository clientRepository;

    @Autowired
    public Client_Controller(Client_Repository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/IdAsc")
    public List<Client> sortById() {
        return clientRepository.sortById();
    }

    @GetMapping("/IdDesc")
    public List<Client> sortByIdDesc() {
        return clientRepository.sortDById();
    }

    @GetMapping("/NumeAsc")
    public List<Client> sortByNume() {
        return clientRepository.sortByNume();
    }

    @GetMapping("/NumeDesc")
    public List<Client> sortByNumeDesc() {
        return clientRepository.sortDByNume();
    }

    @GetMapping("/PrenumeAsc")
    public List<Client> sortByPrenume() {
        return clientRepository.sortByPrenume();
    }

    @GetMapping("/PrenumeDesc")
    public List<Client> sortByPrenumeDesc() {
        return clientRepository.sortDByPrenume();
    }

    @GetMapping("/EmailAsc")
    public List<Client> sortByEmail() {
        return clientRepository.sortByEmail();
    }

    @GetMapping("/EmailDesc")
    public List<Client> sortByEmailDesc() {
        return clientRepository.sortDByEmail();
    }

    @PostMapping("/add")
    public Client addClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    // Șterge un client dupa ID
    @DeleteMapping("/delete/{id}")
    public String deleteClient(@PathVariable Integer id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return "Clientul cu ID " + id + " a fost sters.";
        } else {
            return "Clientul cu ID " + id + " nu exista.";
        }
    }

    // Actualizeaza un client existent
    @PutMapping("/update/{id}")
    public Client updateClient(@PathVariable Integer id, @RequestBody Client clientDetails) {
        return clientRepository.findById(id).map(client -> {
            client.setNume(clientDetails.getNume());
            client.setPrenume(clientDetails.getPrenume());
            client.setEmail(clientDetails.getEmail());
            client.setTelefon(clientDetails.getTelefon());
            client.setTaraProvenienta(clientDetails.getTaraProvenienta());
            return clientRepository.save(client);
        }).orElseThrow(() -> new RuntimeException("Clientul cu ID " + id + " nu exista."));
    }
}
