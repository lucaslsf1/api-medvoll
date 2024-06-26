package med.voll.api.controller;

import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.cliente.Cliente;
import med.voll.api.cliente.DadosAtualizaCliente;
import med.voll.api.cliente.DadosCadastroCliente;
import med.voll.api.cliente.DadosListagemCliente;
import med.voll.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    ClienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastra(@RequestBody @Valid DadosCadastroCliente dados) {
        System.out.println(dados);
        repository.save(new Cliente(dados));
    }

    @GetMapping
    public Page<DadosListagemCliente> lista(@PageableDefault(sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemCliente::new);
    }

    @PutMapping
    @Transactional
    public void atualiza(@RequestBody @Valid DadosAtualizaCliente dados) {
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizaCliente(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void exclui(@PathVariable Long id) {
        var cliente = repository.getReferenceById(id);
        cliente.excluir();
    }
}
