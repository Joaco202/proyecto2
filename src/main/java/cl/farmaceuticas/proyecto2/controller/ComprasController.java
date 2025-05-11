package cl.farmaceuticas.proyecto2.controller;
import cl.farmaceuticas.proyecto2.model.Compras;
import cl.farmaceuticas.proyecto2.service.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/compras")
@CrossOrigin(origins = "*")
public class ComprasController {

    private final ComprasService comprasService;

    @Autowired
    public ComprasController(ComprasService comprasService) {
        this.comprasService = comprasService;
    }

    // Obtener todas las compras
    @GetMapping
    public List<Compras> getAll() {
        return comprasService.findAll();
    }

    // Obtener una compra por ID
    @GetMapping("/{id}")
    public Optional<Compras> getById(@PathVariable Integer id) {
        return comprasService.findById(id);
    }

    // Obtener una compra por número
    @GetMapping("/numero/{numeroCompra}")
    public Optional<Compras> getByNumeroCompra(@PathVariable String numeroCompra) {
        return comprasService.findByNumeroCompra(numeroCompra);
    }

    // Crear una nueva compra
    @PostMapping
    public Compras create(@RequestBody Compras compra) {
        return comprasService.create(compra);
    }

    // Actualizar una compra
    @PutMapping("/{id}")
    public Optional<Compras> update(@PathVariable Integer id, @RequestBody Compras newData) {
        return comprasService.update(id, newData);
    }

    // Eliminar una compra
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        comprasService.delete(id);
    }
}

