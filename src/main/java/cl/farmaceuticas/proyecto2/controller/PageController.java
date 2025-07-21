package cl.farmaceuticas.proyecto2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/registro")
    public String registro() {
        return "registro"; // devuelve registro.html en templates
    }
    @GetMapping("/beneficiarios")
    public String beneficiario() {
        return "beneficiarios"; // devuelve registro.html en templates
    }
    @GetMapping("/compras")
    public String compras() {
        return "compras"; // devuelve registro.html en templates
    }
    @GetMapping("/menu")
    public String menu() {
        return "menu"; // devuelve registro.html en templates
    }
    @GetMapping("/listaventas")
    public String listaventas() {
        return "listaventas"; // devuelve registro.html en templates
    }
    @GetMapping("/login")
    public String login() {
        return "login"; // devuelve registro.html en templates
    }
    @GetMapping("/inicio")
    public String inicio() {
        return "inicio"; // devuelve registro.html en templates
    }
    @GetMapping("/producto")
    public String producto() {
        return "producto"; // devuelve registro.html en templates
    }
    @GetMapping("/regisbenefi")
    public String regisbenefi() {
        return "regisbenefi"; // devuelve registro.html en templates
    }
    @GetMapping("/rol")
    public String rol() {
        return "rol"; // devuelve registro.html en templates
    }
    @GetMapping("/ventas")
    public String ventas() {
        return "ventas"; // devuelve registro.html en templates
    }
}