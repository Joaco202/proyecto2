package cl.farmaceuticas.proyecto2.controller;

import cl.farmaceuticas.proyecto2.model.Fraccionamientos;
import cl.farmaceuticas.proyecto2.service.FraccionamientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fraccionamientos")
@CrossOrigin(origins = "*")
public class FraccionamientosController {

    private final FraccionamientosService fraccionamientosService;

    @Autowired
    public FraccionamientosController(FraccionamientosService fraccionamientosService) {
        this.fraccionamientosService = fraccionamientosService;
    }

    // Obtener todos los fraccionamientos
    @GetMapping
    public List<Fraccionamientos> getAll() {
        return fraccionamientosService.findAll();
    }

    // Obtener fraccionamiento por ID
    @GetMapping("/{id}")
    public Optional<Fraccionamientos> getById(@PathVariable Integer id) {
        return fraccionamientosService.findById(id);
    }

    // Crear nuevo fraccionamiento
    @PostMapping
    public Fraccionamientos create(@RequestBody Fraccionamientos fraccionamiento) {
        return fraccionamientosService.create(fraccionamiento);
    }

    // Actualizar fraccionamiento existente
    @PutMapping("/{id}")
    public Optional<Fraccionamientos> update(@PathVariable Integer id, @RequestBody Fraccionamientos newData) {
        return fraccionamientosService.update(id, newData);
    }

    // Eliminar fraccionamiento
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        fraccionamientosService.delete(id);
    }
}

