package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.Bodega;
import cl.farmaceuticas.proyecto2.repository.BodegaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BodegaService {

    @Autowired
    private BodegaRepository bodegaRepository;

    public List<Bodega> findAll() {
        return bodegaRepository.findAll();
    }

    public Optional<Bodega> findById(Integer id) {
        return bodegaRepository.findById(id);
    }

    public Bodega save(Bodega bodega) {
        return bodegaRepository.save(bodega);
    }

    public Bodega update(Integer id, Bodega datos) {
        return bodegaRepository.findById(id).map(b -> {
            b.setNombre(datos.getNombre());
            b.setDescripcion(datos.getDescripcion());
            return bodegaRepository.save(b);
        })
        .orElseThrow(() -> new RuntimeException("Bodega no encontrada"));
    }

    public boolean delete(Integer id) {
        if (bodegaRepository.existsById(id)) {
            bodegaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
