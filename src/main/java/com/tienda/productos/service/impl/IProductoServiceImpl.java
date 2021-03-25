package com.tienda.productos.service.impl;
import com.tienda.productos.models.entity.Producto;
import com.tienda.productos.repository.IProductoRepository;
import com.tienda.productos.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class IProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoRepository iProductoRepository;

    @Override
    public Producto guardar(Producto producto) {
        return this.iProductoRepository.save(producto);
    }

    @Override
    public Map<String, Object> eliminar(Long id) {
        Optional<Producto> productoEncontrado = this.buscar(id);
        Map<String,Object> response = new HashMap<>();
        if (productoEncontrado.isPresent()) {
            response.put("ELIMINADO","ID "+ id + " ELIMINADO ");
            this.iProductoRepository.delete(productoEncontrado.get());
        } else {
            response.put("ERROR","ID "+ id + " NO ENCONTRADO ");

        }
        return response;
    }

    @Override
    public Optional<Producto> buscar(Long id) {

        return this.iProductoRepository.findById(id);
    }

    @Override
    public Optional<List<Producto>> buscarTodo() {
        List<Producto> productos = (List<Producto>) this.iProductoRepository.findAll();
        return Optional.of(productos);
    }
}
