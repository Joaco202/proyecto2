package cl.farmaceuticas.proyecto2.controller;

import cl.farmaceuticas.proyecto2.model.Beneficiarios;
import cl.farmaceuticas.proyecto2.service.BeneficiariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/beneficiarios")
@CrossOrigin(origins = "*") // Opcional: permite solicitudes desde otros dominios
public class BeneficiariosController {

    private final BeneficiariosService beneficiariosService;

    @Autowired
    public BeneficiariosController(BeneficiariosService beneficiariosService) {
        this.beneficiariosService = beneficiariosService;
    }

    // Obtener todos los beneficiarios
    @GetMapping
    public List<Beneficiarios> getAll() {
        return beneficiariosService.findAll();
    }

    // Obtener un beneficiario por ID
    @GetMapping("/{id}")
    public Optional<Beneficiarios> getById(@PathVariable Integer id) {
        return beneficiariosService.findById(id);
    }

    // Crear un nuevo beneficiario
    @PostMapping
    public Beneficiarios create(@RequestBody Beneficiarios beneficiario) {
        return beneficiariosService.create(beneficiario);
    }

    // Actualizar un beneficiario existente
    @PutMapping("/{id}")
    public Optional<Beneficiarios> update(@PathVariable Integer id, @RequestBody Beneficiarios beneficiario) {
        return beneficiariosService.update(id, beneficiario);
    }

    // Eliminar un beneficiario
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        beneficiariosService.delete(id);
    }
}

