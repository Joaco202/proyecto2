package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.MovimientosInventario;
import cl.farmaceuticas.proyecto2.repository.MovimientosInventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientosInventarioService {

    private final MovimientosInventarioRepository movimientosInventarioRepository;

    @Autowired
    public MovimientosInventarioService(MovimientosInventarioRepository movimientosInventarioRepository) {
        this.movimientosInventarioRepository = movimientosInventarioRepository;
    }

    public List<MovimientosInventario> findAll() {
        return movimientosInventarioRepository.findAll();
    }

    public Optional<MovimientosInventario> findById(Integer id) {
        return movimientosInventarioRepository.findById(id);
    }

    public List<MovimientosInventario> findByProductoId(Integer productoId) {
        return movimientosInventarioRepository.findByProductoId(productoId);
    }

    public MovimientosInventario create(MovimientosInventario movimiento) {
        return movimientosInventarioRepository.save(movimiento);
    }

    public Optional<MovimientosInventario> update(Integer id, MovimientosInventario newData) {
        return movimientosInventarioRepository.findById(id)
                .map(existing -> {
                    existing.setProducto(newData.getProducto());
                    existing.setLote(newData.getLote());
                    existing.setBodega(newData.getBodega());
                    existing.setTipoMovimiento(newData.getTipoMovimiento());
                    existing.setModuloReferencia(newData.getModuloReferencia());
                    existing.setIdReferencia(newData.getIdReferencia());
                    existing.setCantidad(newData.getCantidad());
                    existing.setUsuario(newData.getUsuario());
                    return movimientosInventarioRepository.save(existing);
                });
    }





    public void delete(Integer id) {
        movimientosInventarioRepository.deleteById(id);
    }
}
