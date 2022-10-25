
package com.example.Portfolio.service;

import com.example.Portfolio.model.Educacion;
import com.example.Portfolio.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{

    @Autowired
    public EducacionRepository eduRepo;
    
    @Override
    public List<Educacion> verEducacion() {
        return eduRepo.findAll();
    }

    @Override
    public void crearEducacion(Educacion e) {
        eduRepo.save(e);
    }

    @Override
    public Educacion modificarEducacion(Educacion e, Long id) {
        Educacion edit = eduRepo.findById(id).get();
        edit.setTitulo(e.getTitulo());
        edit.setLink(e.getLink());
        edit.setImagen(e.getImagen());
        edit.setDescripcion(e.getDescripcion());
        return eduRepo.save(edit);
        
    }
    
    @Override
    public void borrarEducacion(Long id) {
        eduRepo.deleteById(id);
    }

    @Override
    public Educacion buscarEducacion(Long id) {
        return eduRepo.findById(id).orElse(null);
    }
    
    
    
}
