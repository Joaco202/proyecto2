package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.NotasCredito;
import cl.farmaceuticas.proyecto2.repository.NotasCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotasCreditoService {

    private final NotasCreditoRepository notasCreditoRepository;

    @Autowired
    public NotasCreditoService(NotasCreditoRepository notasCreditoRepository) {
        this.notasCreditoRepository = notasCreditoRepository;
    }

    public List<NotasCredito> findAll() {
        return notasCreditoRepository.findAll();
    }

    public Optional<NotasCredito> findById(Integer id) {
        return notasCreditoRepository.findById(id);
    }

    public Optional<NotasCredito> findByNumeroNotaCredito(String numeroNotaCredito) {
        return notasCreditoRepository.findByNumeroNotaCredito(numeroNotaCredito);
    }

    public NotasCredito create(NotasCredito notaCredito) {
        return notasCreditoRepository.save(notaCredito);
    }

    public Optional<NotasCredito> update(Integer id, NotasCredito newData) {
        return notasCreditoRepository.findById(id)
                .map(existing -> {
                    existing.setNumeroNotaCredito(newData.getNumeroNotaCredito());
                    existing.setCompra(newData.getCompra()); // Aquí se usa la entidad completa
                    existing.setFecha(newData.getFecha());
                    existing.setMonto(newData.getMonto());
                    existing.setMotivo(newData.getMotivo());
                    return notasCreditoRepository.save(existing);
                });
    }


    public void delete(Integer id) {
        notasCreditoRepository.deleteById(id);
    }
}

