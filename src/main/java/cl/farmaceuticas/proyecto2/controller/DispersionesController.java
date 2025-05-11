package cl.farmaceuticas.proyecto2.controller;

import cl.farmaceuticas.proyecto2.model.Dispersiones;
import cl.farmaceuticas.proyecto2.service.DispersionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dispersiones")
@CrossOrigin(origins = "*")
public class DispersionesController {

    private final DispersionesService dispersionesService;

    @Autowired
    public DispersionesController(DispersionesService dispersionesService) {
        this.dispersionesService = dispersionesService;
    }

    // Obtener todas las dispersiones
    @GetMapping
    public List<Dispersiones> getAll() {
        return dispersionesService.findAll();
    }

    // Obtener una dispersion por ID
    @GetMapping("/{id}")
    public Optional<Dispersiones> getById(@PathVariable Integer id) {
        return dispersionesService.findById(id);
    }

    // Crear una nueva dispersion
    @PostMapping
    public Dispersiones create(@RequestBody Dispersiones dispersion) {
        return dispersionesService.create(dispersion);
    }

    // Actualizar una dispersion existente
    @PutMapping("/{id}")
    public Optional<Dispersiones> update(@PathVariable Integer id, @RequestBody Dispersiones newData) {
        return dispersionesService.update(id, newData);
    }

    // Eliminar una dispersion
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        dispersionesService.delete(id);
    }
}
