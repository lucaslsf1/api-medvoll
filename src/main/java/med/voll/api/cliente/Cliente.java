package med.voll.api.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import med.voll.api.enderecos.Endereco;

@Table(name = "clientes")
@Entity(name = "Cliente")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    @Embedded
    private Endereco endereco;

    public Cliente(DadosCadastroCliente dados) {
        this.nome     = dados.nome();
        this.email    = dados.email();
        this.telefone = dados.telefone();
        this.cpf      = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }
}
