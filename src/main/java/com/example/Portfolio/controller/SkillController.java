/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Portfolio.controller;

import com.example.Portfolio.model.Skill;
import com.example.Portfolio.service.ISkillService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillController {
    
    @Autowired
    private ISkillService skServ;
    
    @GetMapping("skill/ver")
    @ResponseBody
    public List<Skill> verSkill(){
        return skServ.verSkill();
    }
    
    @PostMapping("skill/new")
    public void crearSkill(@RequestBody Skill s){
        skServ.crearSkill(s);
    }
    
    @PostMapping("skill/modificar/{id}")
    public void modificarSkill(@RequestBody Skill s, @PathVariable Long id){
        skServ.modificarSkill(s, id);
    }
    
    
    @DeleteMapping("skill/delete/{id}")
    public void borrarSkill (@PathVariable Long id){
        skServ.borrarSkill(id);
    }
    
    
}
