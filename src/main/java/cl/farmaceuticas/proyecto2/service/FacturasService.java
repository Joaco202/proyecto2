package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.Facturas;
import cl.farmaceuticas.proyecto2.repository.FacturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FacturasService {

    @Autowired
    private final FacturasRepository repository;

    public FacturasService(FacturasRepository repository) {
        this.repository = repository;
    }

    public List<Facturas> findAll() {
        return repository.findAll();
    }

    public Optional<Facturas> findById(Integer id) {
        return repository.findById(id);
    }

    public Facturas save(Facturas e) {
        return repository.save(e);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
