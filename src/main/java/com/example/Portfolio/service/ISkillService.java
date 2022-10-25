
package com.example.Portfolio.service;

import com.example.Portfolio.model.Skill;
import java.util.List;
import org.springframework.stereotype.Service;


public interface ISkillService {
    
    
    public List<Skill> verSkill();
    public void crearSkill (Skill s);
    public Skill modificarSkill (Skill s, Long id);
    public void borrarSkill(Long id);
    public Skill buscarSkill(Long id);
}
