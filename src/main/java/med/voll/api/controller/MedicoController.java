package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastra(@RequestBody @Valid DadosCadastroMedico dados){
        System.out.println(dados);
        repository.save(new Medico(dados));
    }

    @GetMapping
    //Pageable é uma interface já disponibilizada pelo Spring por ser comum, nos permite paginar o conteúdo das listas.
    public Page<DadosListagemMedico> lista(@PageableDefault(sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }
}
