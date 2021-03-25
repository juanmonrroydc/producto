package com.tienda.productos.controller;

import com.tienda.productos.models.entity.Producto;
import com.tienda.productos.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("producto")
public class ProductoController {
    @Autowired
    private IProductoService iProductoService;

    @PostMapping("/crear")
    public Producto crear(@RequestBody Producto producto) {
        return this.iProductoService.guardar(producto);
    }

    @GetMapping("/buscar/{id}")
    public Producto buscar(@PathVariable Long id) {
        return this.iProductoService.buscar(id).orElse(null);
    }

    @PostMapping("/eliminar/{id}")
    Map<String, Object> eliminar(@PathVariable Long id) {
        return this.iProductoService.eliminar(id);
    }
    @GetMapping("/mostrarTodo")
    public List<Producto> mostrarTodo(){
        return this.iProductoService.buscarTodo().get();
    }

}
