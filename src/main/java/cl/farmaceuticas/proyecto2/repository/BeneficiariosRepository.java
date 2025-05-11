package cl.farmaceuticas.proyecto2.repository;
import cl.farmaceuticas.proyecto2.model.Beneficiarios;
import cl.farmaceuticas.proyecto2.model.HistorialPacientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BeneficiariosRepository extends JpaRepository<Beneficiarios, Long> {

}
