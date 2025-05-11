package cl.farmaceuticas.proyecto2.controller;

import cl.farmaceuticas.proyecto2.model.TransaccionesCaja;
import cl.farmaceuticas.proyecto2.service.TransaccionesCajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transacciones-caja")
public class TransaccionesCajaController {

    @Autowired
    private TransaccionesCajaService transaccionesCajaService;

    @GetMapping
    public ResponseEntity<List<TransaccionesCaja>> findAll() {
        List<TransaccionesCaja> transacciones = transaccionesCajaService.findAll();
        return new ResponseEntity<>(transacciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransaccionesCaja> findById(@PathVariable Integer id) {
        Optional<TransaccionesCaja> transaccion = transaccionesCajaService.findById(id);
        return transaccion.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TransaccionesCaja> create(@RequestBody TransaccionesCaja transaccion) {
        TransaccionesCaja created = transaccionesCajaService.save(transaccion);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransaccionesCaja> update(@PathVariable Integer id, @RequestBody TransaccionesCaja transaccion) {
        Optional<TransaccionesCaja> existing = transaccionesCajaService.findById(id);
        if (existing.isPresent()) {
            TransaccionesCaja updated = transaccionesCajaService.update(id, transaccion);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        transaccionesCajaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
