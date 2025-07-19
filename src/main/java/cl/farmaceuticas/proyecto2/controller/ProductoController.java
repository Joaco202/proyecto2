package cl.farmaceuticas.proyecto2.controller;

import cl.farmaceuticas.proyecto2.model.Producto;
import cl.farmaceuticas.proyecto2.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> findAll() {
        List<Producto> productos = productoService.findAll();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> findById(@PathVariable Integer id) {
        Optional<Producto> producto = productoService.findById(id);
        return producto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto producto) {
        // Validaciones básicas
        if (producto.getCodigo() == null || producto.getNombre() == null || producto.getPrecio() == null || producto.getPrecio() < 0) {
            return ResponseEntity.badRequest().build();
        }

        // Valor por defecto para campos obligatorios
        if (producto.getActivo() == null) {
            producto.setActivo(true); // o false según tu lógica
        }

        try {
            Producto created = productoService.save(producto);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace(); // Muestra error en consola
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Integer id, @RequestBody Producto producto) {
        Optional<Producto> existing = productoService.findById(id);
        if (existing.isPresent()) {
            Producto updated = productoService.update(id, producto);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
