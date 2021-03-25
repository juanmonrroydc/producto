package com.tienda.productos.service;

import com.tienda.productos.models.entity.Producto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IProductoService {

    Producto guardar(Producto producto);
    Map<String, Object> eliminar(Long id);
    Optional<Producto> buscar(Long id);
    Optional<List<Producto>> buscarTodo();

}
