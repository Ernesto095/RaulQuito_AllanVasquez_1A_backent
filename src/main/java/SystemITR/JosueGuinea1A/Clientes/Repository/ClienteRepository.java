package SystemITR.JosueGuinea1A.Clientes.Repository;

import SystemITR.JosueGuinea1A.Clientes.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    static boolean existsByEmailIgnoreCase(String email) {
        return false;
    }

    static boolean existsByEmailIgnoreCaseAndIdClienteNot(
            String email,
            Long idCliente
    ) {
        return false;
    }
}