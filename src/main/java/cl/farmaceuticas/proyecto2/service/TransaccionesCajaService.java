package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.TransaccionesCaja;
import cl.farmaceuticas.proyecto2.repository.TransaccionesCajaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TransaccionesCajaService {

    @Autowired
    private final TransaccionesCajaRepository repository;

    public TransaccionesCajaService(TransaccionesCajaRepository repository) {
        this.repository = repository;
    }

    public List<TransaccionesCaja> findAll() {
        return repository.findAll();
    }

    public Optional<TransaccionesCaja> findById(Integer id) {
        return repository.findById(id);
    }

    public TransaccionesCaja save(TransaccionesCaja e) {
        return repository.save(e);
    }

    public TransaccionesCaja update(Integer id, TransaccionesCaja datos) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setTipo(datos.getTipo());
                    existing.setMonto(datos.getMonto());
                    existing.setDescripcion(datos.getDescripcion());
                    existing.setUsuarioId(datos.getUsuarioId());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Transacción no encontrada"));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
