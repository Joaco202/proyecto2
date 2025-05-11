package cl.farmaceuticas.proyecto2.controller;
import cl.farmaceuticas.proyecto2.model.CargasInventario;
import cl.farmaceuticas.proyecto2.service.CargasInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cargas-inventario")
@CrossOrigin(origins = "*")
public class CargasInventarioController {

    private final CargasInventarioService cargasInventarioService;

    @Autowired
    public CargasInventarioController(CargasInventarioService cargasInventarioService) {
        this.cargasInventarioService = cargasInventarioService;
    }

    // Obtener todas las cargas
    @GetMapping
    public List<CargasInventario> getAll() {
        return cargasInventarioService.findAll();
    }

    // Obtener una carga por ID
    @GetMapping("/{id}")
    public Optional<CargasInventario> getById(@PathVariable Integer id) {
        return cargasInventarioService.findById(id);
    }

    // Crear una nueva carga
    @PostMapping
    public CargasInventario create(@RequestBody CargasInventario cargaInventario) {
        return cargasInventarioService.create(cargaInventario);
    }

    // Actualizar una carga existente
    @PutMapping("/{id}")
    public Optional<CargasInventario> update(@PathVariable Integer id, @RequestBody CargasInventario newData) {
        return cargasInventarioService.update(id, newData);
    }

    // Eliminar una carga por ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        cargasInventarioService.delete(id);
    }
}

