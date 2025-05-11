package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.LoteProducto;
import cl.farmaceuticas.proyecto2.repository.LoteProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoteProductoService {

    private final LoteProductoRepository loteProductoRepository;

    @Autowired
    public LoteProductoService(LoteProductoRepository loteProductoRepository) {
        this.loteProductoRepository = loteProductoRepository;
    }

    public List<LoteProducto> findAll() {
        return loteProductoRepository.findAll();
    }

    public Optional<LoteProducto> findById(Integer id) {
        return loteProductoRepository.findById(id);
    }


    public LoteProducto create(LoteProducto lote) {
        return loteProductoRepository.save(lote);
    }

    public Optional<LoteProducto> update(Integer id, LoteProducto newData) {
        return loteProductoRepository.findById(id)
                .map(existing -> {
                    existing.setProductoId(newData.getProductoId());
                    existing.setNumeroLote(newData.getNumeroLote());
                    existing.setFechaVencimiento(newData.getFechaVencimiento());
                    existing.setBodegaId(newData.getBodegaId());
                    existing.setCantidad(newData.getCantidad());
                    return loteProductoRepository.save(existing);
                });
    }

    public void delete(Integer id) {
        loteProductoRepository.deleteById(id);
    }
}
