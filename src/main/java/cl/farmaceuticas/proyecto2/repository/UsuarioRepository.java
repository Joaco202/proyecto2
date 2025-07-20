package cl.farmaceuticas.proyecto2.repository;
import cl.farmaceuticas.proyecto2.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findById(Integer id);
    boolean existsById(Integer id);
    Optional<Usuario> findByUsuario(String usuario);
    boolean existsByUsuario(String usuario);

}
