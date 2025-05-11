package cl.farmaceuticas.proyecto2.controller;

import cl.farmaceuticas.proyecto2.model.ElementosVenta;
import cl.farmaceuticas.proyecto2.service.ElementosVentaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/elementos-venta")
public class ElementosVentaController {

    /*Creo que se antes se necesita hacer el ventas controller
    private final ElementosVentaService elementosVentaService;

    public ElementosVentaController(ElementosVentaService elementosVentaService) {
        this.elementosVentaService = elementosVentaService;
    }

    @GetMapping
    public List<ElementosVenta> getAll() {
        return elementosVentaService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ElementosVenta> getById(@PathVariable Integer id) {
        return elementosVentaService.findById(id);
    }

    @PostMapping
    public ElementosVenta create(@RequestBody ElementosVenta e) {
        return elementosVentaService.save(e);
    }

    @PutMapping("/{id}")
    public Optional<ElementosVenta> update(@PathVariable Integer id, @RequestBody ElementosVenta datos) {
        return Optional.of(elementosVentaService.update(id, datos));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        elementosVentaService.delete(id);
    }*/
}
