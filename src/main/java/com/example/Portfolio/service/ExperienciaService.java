
package com.example.Portfolio.service;

import com.example.Portfolio.model.Experiencia;
import com.example.Portfolio.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService{

    @Autowired
    public ExperienciaRepository expRepo;
    
    @Override
    public List<Experiencia> verExperiencia() {
        return expRepo.findAll();
    }

    @Override
    public void crearExperiencia(Experiencia e) {
        expRepo.save(e);
    }

    @Override
    public Experiencia modificarExperiencia(Experiencia e, Long id) {
        Experiencia edit = expRepo.findById(id).get();
        edit.setTitulo(e.getTitulo());
        edit.setLink(e.getLink());
        edit.setImagen(e.getImagen());
        edit.setDescripcion(e.getDescripcion());
        return expRepo.save(edit);
        
    }
    
    @Override
    public void borrarExperiencia(Long id) {
        expRepo.deleteById(id);
    }

    @Override
    public Experiencia buscarExperiencia(Long id) {
        return expRepo.findById(id).orElse(null);
    }
    
    
    
}
