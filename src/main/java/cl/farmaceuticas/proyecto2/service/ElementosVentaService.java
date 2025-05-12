package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.ElementosVenta;
import cl.farmaceuticas.proyecto2.repository.ElementosVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ElementosVentaService {
    
    @Autowired
    private final ElementosVentaRepository repository;

    public ElementosVentaService(ElementosVentaRepository repository) {
        this.repository = repository;
    }

    public List<ElementosVenta> findAll() {
        return repository.findAll();
    }

    public Optional<ElementosVenta> findById(Integer id) {
        return repository.findById(id);
    }

    public ElementosVenta save(ElementosVenta e) {
        return repository.save(e);
    }

    public ElementosVenta update(Integer id, ElementosVenta datos) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setProducto(datos.getProducto());
                    existing.setLote(datos.getLote());
                    existing.setCantidad(datos.getCantidad());
                    existing.setPrecio(datos.getPrecio());
                    existing.setDescuento(datos.getDescuento());
                    existing.setVenta(datos.getVenta());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Elemento no encontrado"));
    }


    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
