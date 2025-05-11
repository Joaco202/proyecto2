package cl.farmaceuticas.proyecto2.controller;

import cl.farmaceuticas.proyecto2.model.Bodega;
import cl.farmaceuticas.proyecto2.service.BodegaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bodegas")
public class BodegaController {

    private final BodegaService bodegaService;

    public BodegaController(BodegaService bodegaService) {
        this.bodegaService = bodegaService;
    }

    @GetMapping
    public List<Bodega> getAllBodegas() {
        return bodegaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bodega> getBodegaById(@PathVariable Integer id) {
        return bodegaService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

     @PostMapping
    public ResponseEntity<Bodega> crear(@RequestBody Bodega bodega) {
        Bodega creada = bodegaService.save(bodega);
        return ResponseEntity.ok(creada);
    }

    // Actualizar una bodega existente
    @PutMapping("/{id}")
    public ResponseEntity<Bodega> actualizar(@PathVariable Integer id,@RequestBody Bodega bodega) {
        try {
            Bodega actualizada = bodegaService.update(id, bodega);
            return ResponseEntity.ok(actualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        bodegaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
