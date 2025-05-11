package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.Rol;
import cl.farmaceuticas.proyecto2.repository.RolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {
   
    @Autowired
    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Transactional(readOnly = true)
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Rol> findById(Long id) {
        return rolRepository.findById(id);
    }

    @Transactional
    public Rol crearRol(Rol rol) {
        return rolRepository.save(rol);
    }

    @Transactional
    public Rol actualizarRol(Long idRol, Rol datos) {
        return rolRepository.findById(idRol).map(r -> {
            r.setNombre(datos.getNombre());
            r.setDescripcion(datos.getDescripcion());
            return rolRepository.save(r);
        })
        .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
    }

    @Transactional
    public void eliminarRol(Long idRol) {
        rolRepository.deleteById(idRol);
    }

}
