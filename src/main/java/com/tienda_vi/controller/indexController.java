package com.tienda_vi.controller;

import com.tienda_vi.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class indexController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public String listado(Model model) {
        var lista = productoService.getProductos(false);
        model.addAttribute("productos", lista);
        return "index";

    }
}
