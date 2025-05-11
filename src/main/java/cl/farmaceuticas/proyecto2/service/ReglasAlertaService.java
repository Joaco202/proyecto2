package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.ReglasAlerta;
import cl.farmaceuticas.proyecto2.repository.ReglasAlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReglasAlertaService {

    @Autowired
    private final ReglasAlertaRepository repository;

    public ReglasAlertaService(ReglasAlertaRepository repository) {
        this.repository = repository;
    }

    public Optional<ReglasAlerta> findById(Integer id) {
        return repository.findById(id);
    }

    public List<ReglasAlerta> findAll() {
        return repository.findAll();
    }
    public ReglasAlerta save(ReglasAlerta e) {
        return repository.save(e);
    }

    public ReglasAlerta update(Integer id, ReglasAlerta datos) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setProductoId(datos.getProductoId());
                    existing.setIntervaloDias(datos.getIntervaloDias());
                    existing.setUmbralCantidad(datos.getUmbralCantidad());
                    existing.setActivo(datos.getActivo());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Regla de alerta no encontrada"));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
