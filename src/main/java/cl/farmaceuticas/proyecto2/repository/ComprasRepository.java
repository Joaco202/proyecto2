package cl.farmaceuticas.proyecto2.repository;
import cl.farmaceuticas.proyecto2.model.Compras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface  ComprasRepository extends JpaRepository<Compras, Integer> {

    Optional<Compras> findByNumeroCompra(String numeroCompra);
}

