package cl.farmaceuticas.proyecto2.controller;

import cl.farmaceuticas.proyecto2.model.ElementosListaPrecios;
import cl.farmaceuticas.proyecto2.service.ElementosListaPreciosService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/elementos-lista-precios")
public class ElementosListaPreciosController {
    
    private final ElementosListaPreciosService elementosListaPreciosService;

    public ElementosListaPreciosController(ElementosListaPreciosService elementosListaPreciosService) {
        this.elementosListaPreciosService = elementosListaPreciosService;
    }

    @GetMapping
    public List<ElementosListaPrecios> getAll() {
        return elementosListaPreciosService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ElementosListaPrecios> getById(@PathVariable Integer id) {
        return elementosListaPreciosService.findById(id);
    }

    @PostMapping
    public ElementosListaPrecios create(@RequestBody ElementosListaPrecios e) {
        return elementosListaPreciosService.save(e);
    }

    @PutMapping("/{id}")
    public Optional<ElementosListaPrecios> update(@PathVariable Integer id, @RequestBody ElementosListaPrecios datos) {
        return Optional.of(elementosListaPreciosService.update(id, datos));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        elementosListaPreciosService.delete(id);
    }
}
