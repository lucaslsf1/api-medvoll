package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.enderecos.DadosEndereco;

public record DadosAtualizaMedico(
        //Bean validations anotações
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {

}
