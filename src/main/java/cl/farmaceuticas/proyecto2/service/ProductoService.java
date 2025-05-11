package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.Producto;
import cl.farmaceuticas.proyecto2.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> findAll() {
        return repository.findAll();
    }

    public Optional<Producto> findById(Integer id) {
        return repository.findById(id);
    }

    public Producto save(Producto e) {
        return repository.save(e);
    }

    public Producto update(Integer id, Producto datos) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setCodigo(datos.getCodigo());
                    existing.setNombre(datos.getNombre());
                    existing.setDescripcion(datos.getDescripcion());
                    existing.setUnidad(datos.getUnidad());
                    existing.setActivo(datos.getActivo());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
