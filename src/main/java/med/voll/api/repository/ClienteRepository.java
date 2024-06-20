package med.voll.api.repository;

import med.voll.api.cliente.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Page<Cliente> findAllByAtivoTrue(Pageable paginacao);
}
