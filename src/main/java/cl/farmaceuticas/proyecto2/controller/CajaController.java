package cl.farmaceuticas.proyecto2.controller;

import cl.farmaceuticas.proyecto2.model.Cajas;
import cl.farmaceuticas.proyecto2.service.CajasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cajas")
public class CajaController {

    private final CajasService service;

    public CajaController(CajasService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cajas> listarTodos() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cajas> obtenerPorId(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cajas> crear(@RequestBody Cajas cajas) {
        Cajas creado = service.save(cajas);
        return ResponseEntity.ok(creado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
