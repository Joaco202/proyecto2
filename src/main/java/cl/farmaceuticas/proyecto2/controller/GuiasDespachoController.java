package cl.farmaceuticas.proyecto2.controller;

import cl.farmaceuticas.proyecto2.model.GuiasDespacho;
import cl.farmaceuticas.proyecto2.repository.GuiasDespachoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/guias-despacho")
public class GuiasDespachoController {

    @Autowired
    private GuiasDespachoRepository repository;

    @GetMapping
    public List<GuiasDespacho> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<GuiasDespacho> getById(@PathVariable Integer id) {
        return repository.findById(id);
    }

    @PostMapping
    public GuiasDespacho create(@RequestBody GuiasDespacho e) {
        return repository.save(e);
    }

    @PutMapping("/{id}")
    public GuiasDespacho update(@PathVariable Integer id, @RequestBody GuiasDespacho datos) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setNumeroGuia(datos.getNumeroGuia());
                    existing.setFecha(datos.getFecha());
                    existing.setDestino(datos.getDestino());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Guía de despacho no encontrada"));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
