package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.Dispensaciones;
import cl.farmaceuticas.proyecto2.repository.DispensacionesRepository;
import jakarta.persistence.criteria.CriteriaBuilder.In;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DispensacionesService {

    private final DispensacionesRepository repository;

    public DispensacionesService(DispensacionesRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Dispensaciones> listarTodas() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Dispensaciones> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    @Transactional
    public Dispensaciones guardar(Dispensaciones d) {
        return repository.save(d);
    }

    @Transactional
    public Dispensaciones actualizar(Integer id, Dispensaciones datos) {
        return repository.findById(id)
                   .map(existing -> {
                       //existing.setBeneficiarios(datos.getBeneficiarios());
                       //existing.setProducto(datos.getProducto());
                       existing.setCantidad(datos.getCantidad());
                       existing.setFecha(datos.getFecha());
                       //existing.setLote(datos.getLote());
                       return repository.save(existing);
                   })
                   .orElseThrow(() -> new RuntimeException("Dispensación no encontrada"));
    }

    @Transactional
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
