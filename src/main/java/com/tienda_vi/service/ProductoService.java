
package com.tienda_vi.service;

import com.tienda_vi.domain.Producto;
import java.util.List;

public interface ProductoService {
    
    //Se define la firma del metodo para recuperar los registros de la tabla producto en una lista
    public List<Producto> getProductos(boolean activos);
    
    
    public Producto getProducto(Producto producto);
    
    public void save(Producto producto);
    
    public void delete(Producto producto);
}
