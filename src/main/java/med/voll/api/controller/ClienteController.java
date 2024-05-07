package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.cliente.Cliente;
import med.voll.api.cliente.DadosCadastroCliente;
import med.voll.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteRepository repository;

    @PostMapping
    public void cadastra(@RequestBody @Valid DadosCadastroCliente dados) {
        System.out.println(dados);
        repository.save(new Cliente(dados));
    }
}
