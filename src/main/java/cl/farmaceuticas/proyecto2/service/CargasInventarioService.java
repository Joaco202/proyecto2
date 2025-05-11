package cl.farmaceuticas.proyecto2.service;
import cl.farmaceuticas.proyecto2.model.CargasInventario;
import cl.farmaceuticas.proyecto2.repository.CargasInventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CargasInventarioService {

    private final CargasInventarioRepository cargasInventarioRepository;

    @Autowired
    public CargasInventarioService(CargasInventarioRepository cargasInventarioRepository) {
        this.cargasInventarioRepository = cargasInventarioRepository;
    }

    public List<CargasInventario> findAll() {
        return cargasInventarioRepository.findAll();
    }

    public Optional<CargasInventario> findById(Integer id) {
        return cargasInventarioRepository.findById(id);
    }

    public CargasInventario create(CargasInventario cargaInventario) {
        return cargasInventarioRepository.save(cargaInventario);
    }

    public Optional<CargasInventario> update(Integer id, CargasInventario newData) {
        return cargasInventarioRepository.findById(id)
                .map(existing -> {
                    existing.setProducto(newData.getProducto());
                    existing.setBodega(newData.getBodega());
                    existing.setCantidad(newData.getCantidad());
                    existing.setTipoCarga(newData.getTipoCarga());
                    existing.setUsuario(newData.getUsuario());
                    return cargasInventarioRepository.save(existing);
                });
    }

    public void delete(Integer id) {
        cargasInventarioRepository.deleteById(id);
    }
}

