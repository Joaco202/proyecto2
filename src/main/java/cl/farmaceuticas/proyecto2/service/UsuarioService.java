package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.Usuario;
import cl.farmaceuticas.proyecto2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Optional<Usuario> findById(Integer id) {
        return repository.findById(id);
    }

    public Usuario save(Usuario e) {
        return repository.save(e);
    }

    public Usuario update(Integer id, Usuario datos) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setUsuario(datos.getUsuario());
                    existing.setClaveHash(datos.getClaveHash());
                    existing.setNombre(datos.getNombre());
                    existing.setApellido(datos.getApellido());
                    existing.setCorreo(datos.getCorreo());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
