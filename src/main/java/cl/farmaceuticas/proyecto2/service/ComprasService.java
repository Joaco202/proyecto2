package cl.farmaceuticas.proyecto2.service;
import cl.farmaceuticas.proyecto2.model.Compras;
import cl.farmaceuticas.proyecto2.repository.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ComprasService {

    private final ComprasRepository comprasRepository;

    @Autowired
    public ComprasService(ComprasRepository comprasRepository) {
        this.comprasRepository = comprasRepository;
    }

    public List<Compras> findAll() {
        return comprasRepository.findAll();
    }

    public Optional<Compras> findById(Integer id) {
        return comprasRepository.findById(id);
    }

    public Optional<Compras> findByNumeroCompra(String numeroCompra) {
        return comprasRepository.findByNumeroCompra(numeroCompra);
    }

    public Compras create(Compras compra) {
        return comprasRepository.save(compra);
    }

    public Optional<Compras> update(Integer id, Compras newData) {
        return comprasRepository.findById(id)
                .map(existing -> {
                    existing.setNumeroCompra(newData.getNumeroCompra());
                    existing.setFecha(newData.getFecha());
                    existing.setProveedor(newData.getProveedor());
                    existing.setMontoTotal(newData.getMontoTotal());
                    existing.setEstado(newData.getEstado());
                    return comprasRepository.save(existing);
                });
    }

    public void delete(Integer id) {
        comprasRepository.deleteById(id);
    }
}

