
package com.example.Portfolio.service;

import com.example.Portfolio.model.Proyecto;
import com.example.Portfolio.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{

    @Autowired
    public ProyectoRepository proyRepo;
    
    @Override
    public List<Proyecto> verProyecto() {
        return proyRepo.findAll();
    }

    @Override
    public void crearProyecto(Proyecto p) {
        proyRepo.save(p);
    }

    @Override
    public Proyecto modificarProyecto(Proyecto p, Long id) {
        Proyecto edit = proyRepo.findById(id).get();
        edit.setTitulo(p.getTitulo());
        edit.setLink(p.getLink());
        edit.setImagen(p.getImagen());
        edit.setDescripcion(p.getDescripcion());
        return proyRepo.save(edit);
        
    }
    
    @Override
    public void borrarProyecto(Long id) {
        proyRepo.deleteById(id);
    }

    @Override
    public Proyecto buscarProyecto(Long id) {
        return proyRepo.findById(id).orElse(null);
    }
    
    
    
}
