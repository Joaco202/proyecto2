package cl.farmaceuticas.proyecto2.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Debe haber un archivo login.html en src/main/resources/templates si usas Thymeleaf
    }

    @GetMapping("/menu")
    public String home() {
        return "menu"; // Página después de loguearse
    }
}