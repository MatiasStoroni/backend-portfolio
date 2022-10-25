
package com.example.Portfolio.service;

import com.example.Portfolio.model.Experiencia;
import java.util.List;
import org.springframework.stereotype.Service;


public interface IExperienciaService {
    
    
    public List<Experiencia> verExperiencia();
    public void crearExperiencia (Experiencia e);
    public Experiencia modificarExperiencia (Experiencia e, Long id);
    public void borrarExperiencia(Long id);
    public Experiencia buscarExperiencia(Long id);
}
