package cl.farmaceuticas.proyecto2.controller;

import cl.farmaceuticas.proyecto2.model.Beneficiarios;
import cl.farmaceuticas.proyecto2.service.BeneficiariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/beneficiarios")
@CrossOrigin(origins = "*")
public class BeneficiariosController {

    private final BeneficiariosService beneficiariosService;

    @Autowired
    public BeneficiariosController(BeneficiariosService beneficiariosService) {
        this.beneficiariosService = beneficiariosService;
    }

    @GetMapping
    public List<Beneficiarios> getAll() {
        return beneficiariosService.getAll();
    }

    @GetMapping("/{rut}")
    public Optional<Beneficiarios> getByRut(@PathVariable String rut) {
        return beneficiariosService.getByRut(rut);
    }

    @PostMapping
    public Beneficiarios create(@RequestBody Beneficiarios beneficiario) {
        return beneficiariosService.create(beneficiario);
    }

    @PutMapping("/{rut}")
    public Optional<Beneficiarios> update(@PathVariable String rut, @RequestBody Beneficiarios beneficiario) {
        return beneficiariosService.update(rut, beneficiario);
    }

    @DeleteMapping("/{rut}")
    public void delete(@PathVariable String rut) {
        beneficiariosService.delete(rut);
    }
}
