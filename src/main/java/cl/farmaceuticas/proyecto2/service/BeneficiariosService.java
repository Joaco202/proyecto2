package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.Beneficiarios;
import cl.farmaceuticas.proyecto2.repository.BeneficiariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiariosService {

    private final BeneficiariosRepository beneficiariosRepository;

    @Autowired
    public BeneficiariosService(BeneficiariosRepository beneficiariosRepository) {
        this.beneficiariosRepository = beneficiariosRepository;
    }

    // Método para obtener todos los beneficiarios
    public List<Beneficiarios> getAll() {
        return beneficiariosRepository.findAll();
    }

    // Método para obtener un beneficiario por su RUT (String)
    public Optional<Beneficiarios> getByRut(String rut) {
        return beneficiariosRepository.findById(rut);
    }

    // Crear un nuevo beneficiario
    public Beneficiarios create(Beneficiarios beneficiario) {
        return beneficiariosRepository.save(beneficiario);
    }

    // Actualizar beneficiario existente
    public Optional<Beneficiarios> update(String rut, Beneficiarios beneficiariosData) {
        return beneficiariosRepository.findById(rut)
                .map(existing -> {
                    existing.setNombre(beneficiariosData.getNombre());
                    existing.setApellido(beneficiariosData.getApellido());
                    existing.setFechaNacimiento(beneficiariosData.getFechaNacimiento());
                    existing.setSexo(beneficiariosData.getSexo());
                    existing.setDireccion(beneficiariosData.getDireccion());
                    existing.setComuna(beneficiariosData.getComuna());
                    existing.setTelefono(beneficiariosData.getTelefono());
                    existing.setCorreo(beneficiariosData.getCorreo());
                    existing.setTipoDocumento(beneficiariosData.getTipoDocumento());
                    existing.setNumeroDocumento(beneficiariosData.getNumeroDocumento());
                    return beneficiariosRepository.save(existing);
                });
    }

    // Eliminar beneficiario por RUT
    public void delete(String rut) {
        beneficiariosRepository.deleteById(rut);
    }
}
