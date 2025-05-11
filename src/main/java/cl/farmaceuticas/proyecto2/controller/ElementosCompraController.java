package cl.farmaceuticas.proyecto2.controller;
import cl.farmaceuticas.proyecto2.model.ElementosCompra;
import cl.farmaceuticas.proyecto2.service.ElementosCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/elementos-compra")
@CrossOrigin(origins = "*")
public class ElementosCompraController {

    private final ElementosCompraService elementosCompraService;

    @Autowired
    public ElementosCompraController(ElementosCompraService elementosCompraService) {
        this.elementosCompraService = elementosCompraService;
    }

    // Obtener todos los elementos de compra
    @GetMapping
    public List<ElementosCompra> getAll() {
        return elementosCompraService.findAll();
    }

    // Obtener un elemento por ID
    @GetMapping("/{id}")
    public Optional<ElementosCompra> getById(@PathVariable Integer id) {
        return elementosCompraService.findById(id);
    }

    // Crear un nuevo elemento
    @PostMapping
    public ElementosCompra create(@RequestBody ElementosCompra elemento) {
        return elementosCompraService.create(elemento);
    }

    // Actualizar un elemento existente
    @PutMapping("/{id}")
    public Optional<ElementosCompra> update(@PathVariable Integer id, @RequestBody ElementosCompra newData) {
        return elementosCompraService.update(id, newData);
    }

    // Eliminar un elemento
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        elementosCompraService.delete(id);
    }
}

