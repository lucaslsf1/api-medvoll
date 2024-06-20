package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosAtualizaMedico;
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
    // Com a anotação transactional, toda a operação será feita dentro de uma transação no banco de dados
    @Transactional
    public void cadastra(@RequestBody @Valid DadosCadastroMedico dados){
        System.out.println(dados);
        repository.save(new Medico(dados));
    }

    @GetMapping
    //Pageable é uma interface já disponibilizada pelo Spring por ser comum, nos permite paginar o conteúdo das listas.
    public Page<DadosListagemMedico> lista(@PageableDefault(sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualiza(@RequestBody @Valid DadosAtualizaMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizaMedico(dados);
        // Pelo método estar ocorrendo dentro de uma transação no banco de dados, toda vez que uma entidade for carregada
        // e alguma coisa for mudada, a JPA automaticamente fará a atualização dos dados.
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void exclui(@PathVariable Long id) {
        // Exclusão física, apaga os dados do banco de dados
        //repository.deleteById(id);
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}
