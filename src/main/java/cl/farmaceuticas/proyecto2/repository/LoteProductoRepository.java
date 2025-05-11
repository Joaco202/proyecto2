package cl.farmaceuticas.proyecto2.repository;
import cl.farmaceuticas.proyecto2.model.LoteProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface LoteProductoRepository extends JpaRepository<LoteProducto, Integer> {
    Optional<LoteProducto> findById(Integer id);
    boolean existsById(Integer id);
    Optional<LoteProducto> findByLote(String lote);
    Optional<LoteProducto> findByLoteAndIdBodega(String lote, Integer idBodega);
    List<LoteProducto> findByProductoId(Integer productoId);

}
