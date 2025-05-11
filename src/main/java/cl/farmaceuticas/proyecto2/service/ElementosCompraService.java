package cl.farmaceuticas.proyecto2.service;
import cl.farmaceuticas.proyecto2.model.ElementosCompra;
import cl.farmaceuticas.proyecto2.repository.ElementosCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ElementosCompraService {

    private final ElementosCompraRepository elementosCompraRepository;

    @Autowired
    public ElementosCompraService(ElementosCompraRepository elementosCompraRepository) {
        this.elementosCompraRepository = elementosCompraRepository;
    }

    public List<ElementosCompra> findAll() {
        return elementosCompraRepository.findAll();
    }

    public Optional<ElementosCompra> findById(Integer id) {
        return elementosCompraRepository.findById(id);
    }

    public ElementosCompra create(ElementosCompra elemento) {
        return elementosCompraRepository.save(elemento);
    }

    public Optional<ElementosCompra> update(Integer id, ElementosCompra newData) {
        return elementosCompraRepository.findById(id)
                .map(existing -> {
                    existing.setCompraId(newData.getCompraId());
                    existing.setProductoId(newData.getProductoId());
                    existing.setLoteId(newData.getLoteId());
                    existing.setCantidad(newData.getCantidad());
                    existing.setPrecio(newData.getPrecio());
                    return elementosCompraRepository.save(existing);
                });
    }

    public void delete(Integer id) {
        elementosCompraRepository.deleteById(id);
    }
}
