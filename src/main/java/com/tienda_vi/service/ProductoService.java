package com.tienda_vi.service;

import com.tienda_vi.domain.Producto;
import java.util.List;

public interface ProductoService {

    //Se define la firma del metodo para recuperar los registros de la tabla producto en una lista
    public List<Producto> getProductos(boolean activos);

    public Producto getProducto(Producto producto);

    public void save(Producto producto);

    public void delete(Producto producto);

    //se define una consulta tipo jpa para recuperar los productos que se encuentran 
    //en un rango de precios ordenados por descripcion ascendente
    public List<Producto> consultaJPA(double precioInf, double precioSup);

    //se define una consulta tipo JPQL para recuperar los productos que se encuentran 
    //en un rango de precios ordenados por descripcion ascendente
    public List<Producto> consultaJPQL(double precioInf, double precioSup);

    //se define una consulta tipo SQL nativa para recuperar los productos que se encuentran 
    //en un rango de precios ordenados por descripcion ascendente
    public List<Producto> consultaSQL(double precioInf, double precioSup);
}
