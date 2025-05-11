package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.Cajas;
import cl.farmaceuticas.proyecto2.repository.CajasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CajasService {

    @Autowired
    private final CajasRepository cajasRepository;

    public CajasService(CajasRepository cajasRepository) {
        this.cajasRepository = cajasRepository;
    }

    public List<Cajas> findAll() {
        return cajasRepository.findAll();
    }

    public Optional<Cajas> findById(Integer id) {
        return cajasRepository.findById(id);
    }

    public Cajas save(Cajas cajas) {
        return cajasRepository.save(cajas);
    }
    
    public boolean delete(Integer id) {
        if (cajasRepository.existsById(id)) {
            cajasRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
