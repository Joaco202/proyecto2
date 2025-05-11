package cl.farmaceuticas.proyecto2.controller;
import cl.farmaceuticas.proyecto2.model.HistorialPacientes;
import cl.farmaceuticas.proyecto2.service.HistorialPacientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/historial-pacientes")
@CrossOrigin(origins = "*")
public class HistorialPacientesController {

    private final HistorialPacientesService historialPacientesService;

    @Autowired
    public HistorialPacientesController(HistorialPacientesService historialPacientesService) {
        this.historialPacientesService = historialPacientesService;
    }

    // Obtener todos los historiales
    @GetMapping
    public List<HistorialPacientes> getAll() {
        return historialPacientesService.findAll();
    }

    // Obtener historial por ID
    @GetMapping("/{id}")
    public Optional<HistorialPacientes> getById(@PathVariable Integer id) {
        return historialPacientesService.findById(id);
    }

    // Obtener historial por ID del beneficiario
    @GetMapping("/beneficiario/{beneficiarioId}")
    public List<HistorialPacientes> getByBeneficiarioId(@PathVariable Integer beneficiarioId) {
        return historialPacientesService.findByBeneficiarioId(beneficiarioId);
    }

    // Crear historial
    @PostMapping
    public HistorialPacientes create(@RequestBody HistorialPacientes historial) {
        return historialPacientesService.create(historial);
    }

    // Actualizar historial
    @PutMapping("/{id}")
    public Optional<HistorialPacientes> update(@PathVariable Integer id, @RequestBody HistorialPacientes newData) {
        return historialPacientesService.update(id, newData);
    }

    // Eliminar historial
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        historialPacientesService.delete(id);
    }
}

