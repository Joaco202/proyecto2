package cl.farmaceuticas.proyecto2.controller;

import cl.farmaceuticas.proyecto2.model.Dispensaciones;
import cl.farmaceuticas.proyecto2.service.DispensacionesService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/dispensaciones")
public class DispensacionController {

    private final DispensacionesService service;

    public DispensacionController(DispensacionesService service) {
        this.service = service;
    }

    // Listar todas las dispensaciones
    @GetMapping
    public List<Dispensaciones> getAll() {
        return service.listarTodas();
    }

    // Obtener una dispensación por ID
    @GetMapping("/{id}")
    public ResponseEntity<Dispensaciones> getById(@PathVariable Integer id) {
        return service.buscarPorId(id)
                      .map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    // Crear una nueva dispensación
    @PostMapping
    public ResponseEntity<Dispensaciones> create(@RequestBody Dispensaciones d) {
        Dispensaciones creada = service.guardar(d);
        return ResponseEntity.ok(creada);
    }

    // Actualizar una dispensación existente
    @PutMapping("/{id}")
    public ResponseEntity<Dispensaciones> update(@PathVariable Integer id, @RequestBody Dispensaciones datos) {
        try {
            Dispensaciones actualizada = service.actualizar(id, datos);
            return ResponseEntity.ok(actualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una dispensación
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
