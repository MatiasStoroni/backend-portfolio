
package com.example.Portfolio.service;

import com.example.Portfolio.model.Proyecto;
import java.util.List;
import org.springframework.stereotype.Service;


public interface IProyectoService {
    
    
    public List<Proyecto> verProyecto();
    public void crearProyecto (Proyecto p);
    public Proyecto modificarProyecto (Proyecto p, Long id);
    public void borrarProyecto(Long id);
    public Proyecto buscarProyecto(Long id);
}
