package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.GuiasDespacho;
import cl.farmaceuticas.proyecto2.repository.GuiasDespachoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GuiasDespachoService{
    @Autowired
    private final GuiasDespachoRepository repository;
    
    public GuiasDespachoService(GuiasDespachoRepository repository) {
        this.repository = repository;
    }

    public List<GuiasDespacho> findAll() {
        return repository.findAll();
    }

    public Optional<GuiasDespacho> findById(Integer id) {
        return repository.findById(id);
    }

    public GuiasDespacho save(GuiasDespacho e) {
        return repository.save(e);
    }

    public GuiasDespacho update(Integer id, GuiasDespacho datos) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setNumeroGuia(datos.getNumeroGuia());
                    existing.setFecha(datos.getFecha());
                    existing.setDestino(datos.getDestino());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Guía de despacho no encontrada"));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
