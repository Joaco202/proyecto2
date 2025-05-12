package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.Dispersiones;
import cl.farmaceuticas.proyecto2.repository.DispersionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DispersionesService {

    private final DispersionesRepository dispersionesRepository;

    @Autowired
    public DispersionesService(DispersionesRepository dispersionesRepository) {
        this.dispersionesRepository = dispersionesRepository;
    }

    public List<Dispersiones> findAll() {
        return dispersionesRepository.findAll();
    }

    public Optional<Dispersiones> findById(Integer id) {
        return dispersionesRepository.findById(id);
    }

    public Dispersiones create(Dispersiones dispersion) {
        return dispersionesRepository.save(dispersion);
    }

    public Optional<Dispersiones> update(Integer id, Dispersiones newData) {
        return dispersionesRepository.findById(id)
                .map(existing -> {
                    //existing.setBeneficiarios(newData.getBeneficiarios());
                    existing.setMonto(newData.getMonto());
                    existing.setFecha(newData.getFecha());
                    existing.setUsuario(newData.getUsuario());
                    existing.setEstado(newData.getEstado());
                    return dispersionesRepository.save(existing);
                });
    }

    public void delete(Integer id) {
        dispersionesRepository.deleteById(id);
    }
}
