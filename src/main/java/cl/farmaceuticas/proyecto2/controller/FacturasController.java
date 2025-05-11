package cl.farmaceuticas.proyecto2.controller;

import cl.farmaceuticas.proyecto2.model.Facturas;
import cl.farmaceuticas.proyecto2.service.FacturasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/facturas")
@CrossOrigin(origins = "*")
public class FacturasController {

    private final FacturasService facturasService;

    @Autowired
    public FacturasController(FacturasService facturasService) {
        this.facturasService = facturasService;
    }

    // Obtener todas las facturas
    @GetMapping
    public List<Facturas> getAll() {
        return facturasService.findAll();
    }

    // Obtener factura por ID
    @GetMapping("/{id}")
    public Optional<Facturas> getById(@PathVariable Integer id) {
        return facturasService.findById(id);
    }

    // Crear o actualizar factura
    @PostMapping
    public Facturas create(@RequestBody Facturas factura) {
        return facturasService.save(factura);
    }

    // Eliminar factura por ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        facturasService.delete(id);
    }
}
