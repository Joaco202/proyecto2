package cl.farmaceuticas.proyecto2.service;

import cl.farmaceuticas.proyecto2.model.Usuario;
import cl.farmaceuticas.proyecto2.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;

    // Inyección de dependencias por constructor
    public UsuarioService(UsuarioRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Optional<Usuario> findById(Integer id) {
        return repository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        // Hashear la clave antes de guardar
        usuario.setClaveHash(passwordEncoder.encode(usuario.getClaveHash()));
        return repository.save(usuario);
    }

    public Usuario update(Integer id, Usuario datos) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setUsuario(datos.getUsuario());
                    // Si la clave cambió, hashearla
                    if (datos.getClaveHash() != null && !datos.getClaveHash().isEmpty()) {
                        existing.setClaveHash(passwordEncoder.encode(datos.getClaveHash()));
                    }
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
