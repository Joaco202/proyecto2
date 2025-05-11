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


    public List<Beneficiarios> findAll() {
        return beneficiariosRepository.findAll();
    }

    public Optional<Beneficiarios> findById(Integer rut) {
        return beneficiariosRepository.findById(rut.longValue());
    }


    public Beneficiarios create(Beneficiarios beneficiario) {
        return beneficiariosRepository.save(beneficiario);
    }


    public Optional<Beneficiarios> update(Integer id, Beneficiarios beneficiariosData) {
        return beneficiariosRepository.findById(id.longValue())
                .map(existing -> {
                    existing.setComuna(beneficiariosData.getComuna());
                    existing.setDireccion(beneficiariosData.getDireccion());
                    existing.setTelefono(beneficiariosData.getTelefono());
                    return beneficiariosRepository.save(existing);
                });
    }


    public void delete(Integer id) {
        beneficiariosRepository.deleteById(id.longValue());
    }
}
