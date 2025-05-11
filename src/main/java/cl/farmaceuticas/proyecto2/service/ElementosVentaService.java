package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.ElementosListaPrecios;
import cl.farmaceuticas.proyecto2.repository.ElementosListaPreciosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ElementosVentaService {
    
    @Autowired
    private final ElementosListaPreciosRepository repository;

    public ElementosVentaService(ElementosListaPreciosRepository repository) {
        this.repository = repository;
    }

    public List<ElementosListaPrecios> findAll() {
        return repository.findAll();
    }

    public Optional<ElementosListaPrecios> findById(Integer id) {
        return repository.findById(id);
    }

    public ElementosListaPrecios save(ElementosListaPrecios e) {
        return repository.save(e);
    }

    public ElementosListaPrecios update(Integer id, ElementosListaPrecios datos) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setListaPrecioId(datos.getListaPrecioId());
                    existing.setProductoId(datos.getProductoId());
                    existing.setPrecio(datos.getPrecio());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Elemento no encontrado"));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
