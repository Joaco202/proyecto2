package cl.farmaceuticas.proyecto2.controller;

import cl.farmaceuticas.proyecto2.model.Producto;
import cl.farmaceuticas.proyecto2.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    /**
     * Muestra la página principal (index.html) con:
     * - lista de productos en "productos"
     * - un objeto vacío "producto" para el formulario
     */
    @GetMapping("/")
    public String mostrarIndex(Model model) {
        model.addAttribute("productos", productoService.findAll());
        model.addAttribute("producto", new Producto());
        return "index"; // Thymeleaf buscará src/main/resources/templates/index.html
    }

    /**
     * Procesa el POST del formulario de creación.
     * Coincide con th:action="@{/productos/guardar}"
     */
    @PostMapping("/productos/guardar")
    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
        productoService.save(producto);
        return "redirect:/";  // recarga la lista en la raíz
    }
}
