package cl.farmaceuticas.proyecto2.controller;
import cl.farmaceuticas.proyecto2.model.NotasCredito;
import cl.farmaceuticas.proyecto2.service.NotasCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notas-credito")
@CrossOrigin(origins = "*")
public class NotasCreditoController {

    private final NotasCreditoService notasCreditoService;

    @Autowired
    public NotasCreditoController(NotasCreditoService notasCreditoService) {
        this.notasCreditoService = notasCreditoService;
    }

    // Obtener todas las notas de crédito
    @GetMapping
    public List<NotasCredito> getAll() {
        return notasCreditoService.findAll();
    }

    // Obtener una nota por ID
    @GetMapping("/{id}")
    public Optional<NotasCredito> getById(@PathVariable Integer id) {
        return notasCreditoService.findById(id);
    }

    // Obtener una nota por número
    @GetMapping("/numero/{numeroNotaCredito}")
    public Optional<NotasCredito> getByNumero(@PathVariable String numeroNotaCredito) {
        return notasCreditoService.findByNumeroNotaCredito(numeroNotaCredito);
    }

    // Crear nueva nota de crédito
    @PostMapping
    public NotasCredito create(@RequestBody NotasCredito notaCredito) {
        return notasCreditoService.create(notaCredito);
    }

    // Actualizar una nota de crédito existente
    @PutMapping("/{id}")
    public Optional<NotasCredito> update(@PathVariable Integer id, @RequestBody NotasCredito newData) {
        return notasCreditoService.update(id, newData);
    }

    // Eliminar una nota de crédito
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        notasCreditoService.delete(id);
    }
}

