package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.Ventas;
import cl.farmaceuticas.proyecto2.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VentasService {

    @Autowired
    private final VentasRepository repository;

    public VentasService(VentasRepository repository) {
        this.repository = repository;
    }

    public Optional<Ventas> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Ventas> findAll() {
        return repository.findAll();
    }

    public Ventas save(Ventas e) {
        return repository.save(e);
    }

    public Ventas update(Integer id, Ventas datos) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setFechaVenta(datos.getFechaVenta());
                    existing.setUsuarioId(datos.getUsuarioId());
                    existing.setMontoTotal(datos.getMontoTotal());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
