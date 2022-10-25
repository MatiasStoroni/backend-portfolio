/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Portfolio.controller;

import com.example.Portfolio.model.Experiencia;
import com.example.Portfolio.service.IExperienciaService;
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
public class ExperienciaController {
    
    @Autowired
    private IExperienciaService expServ;
    
    @GetMapping("experiencia/ver")
    @ResponseBody
    public List<Experiencia> verExperiencia(){
        return expServ.verExperiencia();
    }
    @PostMapping("experiencia/new")
    public void crearExperiencia(@RequestBody Experiencia e){
        expServ.crearExperiencia(e);
    }
    
    @PostMapping("experiencia/modificar/{id}")
    public void modificarExperiencia(@RequestBody Experiencia e, @PathVariable Long id){
        expServ.modificarExperiencia(e, id);
    }
    
    
    @DeleteMapping("experiencia/delete/{id}")
    public void borrarExperiencia (@PathVariable Long id){
        expServ.borrarExperiencia(id);
    }
    
    
}
