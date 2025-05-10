package cl.farmaceuticas.proyecto2.repository;

import cl.farmaceuticas.proyecto2.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{

	public Rol findByNombre(String nombre);
	
}
