package cl.farmaceuticas.proyecto2.repository;
import cl.farmaceuticas.proyecto2.model.CargasInventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CargasInventarioRepository extends JpaRepository<CargasInventario, Integer>{
    
}




