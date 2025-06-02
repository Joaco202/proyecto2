package cl.farmaceuticas.proyecto2.controller;

import cl.farmaceuticas.proyecto2.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> body) {
        var resultado = authService.registrar(
                body.get("usuario"),
                body.get("claveHash"),
                body.get("nombre"),
                body.get("apellido"),
                body.get("correo"),
                body.get("rol")
        );

        if (resultado.isPresent()) {
            return ResponseEntity.ok(Map.of("mensaje", "Usuario registrado con éxito"));
        } else {
            return ResponseEntity.badRequest().body(Map.of("error", "No se pudo registrar el usuario (verifica si ya existe o si el rol es válido)"));
        }
    }
}
