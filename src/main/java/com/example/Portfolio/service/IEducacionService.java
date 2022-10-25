
package com.example.Portfolio.service;

import com.example.Portfolio.model.Educacion;
import java.util.List;
import org.springframework.stereotype.Service;


public interface IEducacionService {
    
    
    public List<Educacion> verEducacion();
    public void crearEducacion (Educacion e);
    public Educacion modificarEducacion (Educacion e, Long id);
    public void borrarEducacion(Long id);
    public Educacion buscarEducacion(Long id);
}
