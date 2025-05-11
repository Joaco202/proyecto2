package cl.farmaceuticas.proyecto2.controller;

import cl.farmaceuticas.proyecto2.model.ReglasAlerta;
import cl.farmaceuticas.proyecto2.service.ReglasAlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reglas-alerta")
public class ReglasAlertaController {

    @Autowired
    private ReglasAlertaService reglasAlertaService;

    @GetMapping
    public ResponseEntity<List<ReglasAlerta>> findAll() {
        List<ReglasAlerta> reglas = reglasAlertaService.findAll();
        return new ResponseEntity<>(reglas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReglasAlerta> findById(@PathVariable Integer id) {
        Optional<ReglasAlerta> regla = reglasAlertaService.findById(id);
        return regla.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ReglasAlerta> create(@RequestBody ReglasAlerta regla) {
        ReglasAlerta created = reglasAlertaService.save(regla);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReglasAlerta> update(@PathVariable Integer id, @RequestBody ReglasAlerta regla) {
        Optional<ReglasAlerta> existing = reglasAlertaService.findById(id);
        if (existing.isPresent()) {
            ReglasAlerta updated = reglasAlertaService.update(id, regla);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        reglasAlertaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
