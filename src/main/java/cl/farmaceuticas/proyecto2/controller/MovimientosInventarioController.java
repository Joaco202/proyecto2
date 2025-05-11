package cl.farmaceuticas.proyecto2.controller;
import cl.farmaceuticas.proyecto2.model.MovimientosInventario;
import cl.farmaceuticas.proyecto2.service.MovimientosInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movimientos-inventario")
@CrossOrigin(origins = "*")
public class MovimientosInventarioController {

    private final MovimientosInventarioService movimientosInventarioService;

    @Autowired
    public MovimientosInventarioController(MovimientosInventarioService movimientosInventarioService) {
        this.movimientosInventarioService = movimientosInventarioService;
    }

    // Obtener todos los movimientos
    @GetMapping
    public List<MovimientosInventario> getAll() {
        return movimientosInventarioService.findAll();
    }

    // Obtener movimiento por ID
    @GetMapping("/{id}")
    public Optional<MovimientosInventario> getById(@PathVariable Integer id) {
        return movimientosInventarioService.findById(id);
    }

    // Obtener movimientos por ID de producto
    @GetMapping("/producto/{productoId}")
    public List<MovimientosInventario> getByProductoId(@PathVariable Integer productoId) {
        return movimientosInventarioService.findByProductoId(productoId);
    }

    // Crear nuevo movimiento
    @PostMapping
    public MovimientosInventario create(@RequestBody MovimientosInventario movimiento) {
        return movimientosInventarioService.create(movimiento);
    }

    // Actualizar movimiento existente
    @PutMapping("/{id}")
    public Optional<MovimientosInventario> update(@PathVariable Integer id, @RequestBody MovimientosInventario newData) {
        return movimientosInventarioService.update(id, newData);
    }

    // Eliminar movimiento
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        movimientosInventarioService.delete(id);
    }
}

