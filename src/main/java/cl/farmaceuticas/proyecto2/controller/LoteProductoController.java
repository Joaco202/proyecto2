package cl.farmaceuticas.proyecto2.controller;

import cl.farmaceuticas.proyecto2.model.LoteProducto;
import cl.farmaceuticas.proyecto2.service.LoteProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lotes-producto")
@CrossOrigin(origins = "*")
public class LoteProductoController {

    private final LoteProductoService loteProductoService;

    @Autowired
    public LoteProductoController(LoteProductoService loteProductoService) {
        this.loteProductoService = loteProductoService;
    }

    // Obtener todos los lotes
    @GetMapping
    public List<LoteProducto> getAll() {
        return loteProductoService.findAll();
    }

    // Obtener lote por ID
    @GetMapping("/{id}")
    public Optional<LoteProducto> getById(@PathVariable Integer id) {
        return loteProductoService.findById(id);
    }


    // Crear nuevo lote
    @PostMapping
    public LoteProducto create(@RequestBody LoteProducto lote) {
        return loteProductoService.create(lote);
    }

    // Actualizar lote existente
    @PutMapping("/{id}")
    public Optional<LoteProducto> update(@PathVariable Integer id, @RequestBody LoteProducto newData) {
        return loteProductoService.update(id, newData);
    }

    // Eliminar lote
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        loteProductoService.delete(id);
    }
}

