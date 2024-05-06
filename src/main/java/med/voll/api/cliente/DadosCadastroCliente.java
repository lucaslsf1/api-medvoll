package med.voll.api.cliente;

import med.voll.api.enderecos.Endereco;

public record DadosCadastroCliente(String nome, String email, String telefone, String cpf, Endereco endereco) {
}
