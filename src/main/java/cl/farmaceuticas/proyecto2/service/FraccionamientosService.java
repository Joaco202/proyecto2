package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.Fraccionamientos;
import cl.farmaceuticas.proyecto2.repository.FraccionamientosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FraccionamientosService {

    private final FraccionamientosRepository fraccionamientosRepository;

    @Autowired
    public FraccionamientosService(FraccionamientosRepository fraccionamientosRepository) {
        this.fraccionamientosRepository = fraccionamientosRepository;
    }

    public List<Fraccionamientos> findAll() {
        return fraccionamientosRepository.findAll();
    }

    public Optional<Fraccionamientos> findById(Integer id) {
        return fraccionamientosRepository.findById(id);
    }

    public Fraccionamientos create(Fraccionamientos fraccionamiento) {
        return fraccionamientosRepository.save(fraccionamiento);
    }

    public Optional<Fraccionamientos> update(Integer id, Fraccionamientos newData) {
        return fraccionamientosRepository.findById(id)
                .map(existing -> {
                    existing.setProductoOriginalId(newData.getProductoOriginalId());
                    existing.setProductoFraccionId(newData.getProductoFraccionId());
                    existing.setCantidad(newData.getCantidad());
                    existing.setFecha(newData.getFecha());
                    existing.setUsuarioId(newData.getUsuarioId());
                    return fraccionamientosRepository.save(existing);
                });
    }

    public void delete(Integer id) {
        fraccionamientosRepository.deleteById(id);
    }
}
