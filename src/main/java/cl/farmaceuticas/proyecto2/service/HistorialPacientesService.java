package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.HistorialPacientes;
import cl.farmaceuticas.proyecto2.repository.HistorialPacientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialPacientesService {

    private final HistorialPacientesRepository historialPacientesRepository;

    @Autowired
    public HistorialPacientesService(HistorialPacientesRepository historialPacientesRepository) {
        this.historialPacientesRepository = historialPacientesRepository;
    }

    public List<HistorialPacientes> findAll() {
        return historialPacientesRepository.findAll();
    }

    public Optional<HistorialPacientes> findById(Integer id) {
        return historialPacientesRepository.findById(id);
    }

    public List<HistorialPacientes> findByBeneficiarioRut(String rut) {
        return historialPacientesRepository.findByBeneficiarioRut(rut);
    }

    public HistorialPacientes create(HistorialPacientes historial) {
        return historialPacientesRepository.save(historial);
    }

    public Optional<HistorialPacientes> update(Integer id, HistorialPacientes newData) {
        return historialPacientesRepository.findById(id)
                .map(existing -> {
                    existing.setBeneficiario(newData.getBeneficiario());
                    existing.setDatosHistorial(newData.getDatosHistorial());
                    return historialPacientesRepository.save(existing);
                });
    }

    public void delete(Integer id) {
        historialPacientesRepository.deleteById(id);
    }
}
