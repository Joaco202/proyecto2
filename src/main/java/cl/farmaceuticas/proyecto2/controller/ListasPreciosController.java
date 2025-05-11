package cl.farmaceuticas.proyecto2.controller;

import cl.farmaceuticas.proyecto2.model.ListasPrecios;
import cl.farmaceuticas.proyecto2.service.ListasPreciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/listas-precios")
@CrossOrigin(origins = "*")
public class ListasPreciosController {

    private final ListasPreciosService listasPreciosService;

    @Autowired
    public ListasPreciosController(ListasPreciosService listasPreciosService) {
        this.listasPreciosService = listasPreciosService;
    }

    // Obtener todas las listas de precios
    @GetMapping
    public List<ListasPrecios> getAll() {
        return listasPreciosService.findAll();
    }

    // Obtener una lista por ID
    @GetMapping("/{id}")
    public Optional<ListasPrecios> getById(@PathVariable Integer id) {
        return listasPreciosService.findById(id);
    }

    // Crear una nueva lista de precios
    @PostMapping
    public ListasPrecios create(@RequestBody ListasPrecios lista) {
        return listasPreciosService.create(lista);
    }

    // Actualizar una lista de precios existente
    @PutMapping("/{id}")
    public Optional<ListasPrecios> update(@PathVariable Integer id, @RequestBody ListasPrecios newData) {
        return listasPreciosService.update(id, newData);
    }

    // Eliminar una lista de precios
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        listasPreciosService.delete(id);
    }
}
