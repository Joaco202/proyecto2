package cl.farmaceuticas.proyecto2.controller;

import cl.farmaceuticas.proyecto2.model.Facturas;
import cl.farmaceuticas.proyecto2.service.FacturasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/facturas")
public class FacturasController {

    @Autowired
    private final FacturasService facturasService;

    public FacturasController(FacturasService facturasService) {
        this.facturasService = facturasService;
    }

    @GetMapping
    public List<Facturas> getAll() {
        return facturasService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Facturas> getById(@PathVariable Integer id) {
        return facturasService.findById(id);
    }

    @PostMapping
    public Facturas create(@RequestBody Facturas e) {
        return facturasService.save(e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        facturasService.delete(id);
    }
}
