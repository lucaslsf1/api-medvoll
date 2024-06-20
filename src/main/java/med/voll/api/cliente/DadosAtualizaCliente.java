package med.voll.api.cliente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.enderecos.DadosEndereco;

public record DadosAtualizaCliente(
        //Bean validations anotações
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {

}
