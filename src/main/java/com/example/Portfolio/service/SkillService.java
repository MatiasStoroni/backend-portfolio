
package com.example.Portfolio.service;

import com.example.Portfolio.model.Skill;
import com.example.Portfolio.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService{

    @Autowired
    public SkillRepository skRepo;
    
    @Override
    public List<Skill> verSkill() {
        return skRepo.findAll();
    }

    @Override
    public void crearSkill(Skill s) {
        skRepo.save(s);
    }

    @Override
    public Skill modificarSkill(Skill s, Long id) {
        Skill edit = skRepo.findById(id).get();
        edit.setTitulo(s.getTitulo());
        edit.setProgreso(s.getProgreso());
        return skRepo.save(edit);
        
    }
    
    @Override
    public void borrarSkill(Long id) {
        skRepo.deleteById(id);
    }

    @Override
    public Skill buscarSkill(Long id) {
        return skRepo.findById(id).orElse(null);
    }
    
    
    
}
