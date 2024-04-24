
package com.tienda_vi.service;

import com.tienda_vi.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    //Se define la firma del metodo para recuperar los registros de la tabla categoria en una lista
    public List<Categoria> getCategorias(boolean activos);
}
