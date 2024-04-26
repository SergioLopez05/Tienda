package com.tienda_vi.service.impl;

import com.tienda_vi.dao.ProductoDao;
import com.tienda_vi.domain.Producto;
import com.tienda_vi.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    public List<Producto> getProductos(boolean activos) {
        var lista = productoDao.findAll();

        if (activos) {//si se quieren solo productos activas
            lista.removeIf(c -> !c.isActivo());
        }

        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {

        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

    //se define una consulta tipo jpa para recuperar los productos que se encuentran 
    //en un rango de precios ordenados por descripcion ascendente
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaJPA(double precioInf, double precioSup) {
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }

    //se define una consulta tipo JPQL para recuperar los productos que se encuentran 
    //en un rango de precios ordenados por descripcion ascendente
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaJPQL(double precioInf, double precioSup) {
        return productoDao.consultaJPQL(precioInf, precioSup);

    }

    //se define una consulta tipo SQL nativa para recuperar los productos que se encuentran 
    //en un rango de precios ordenados por descripcion ascendente
    @Override
    @Transactional(readOnly = true)
    public List<Producto> consultaSQL(double precioInf, double precioSup) {
        return productoDao.consultaSQL(precioInf, precioSup);
    }
}
