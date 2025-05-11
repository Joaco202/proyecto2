package cl.farmaceuticas.proyecto2.controller;

import cl.farmaceuticas.proyecto2.model.Ventas;
import cl.farmaceuticas.proyecto2.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ventas")
public class VentasController {

    @Autowired
    private VentasService ventasService;

    @GetMapping
    public ResponseEntity<List<Ventas>> findAll() {
        List<Ventas> ventas = ventasService.findAll();
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ventas> findById(@PathVariable Integer id) {
        Optional<Ventas> venta = ventasService.findById(id);
        return venta.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ventas> create(@RequestBody Ventas venta) {
        Ventas created = ventasService.save(venta);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ventas> update(@PathVariable Integer id, @RequestBody Ventas venta) {
        Optional<Ventas> existing = ventasService.findById(id);
        if (existing.isPresent()) {
            Ventas updated = ventasService.update(id, venta);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        ventasService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
