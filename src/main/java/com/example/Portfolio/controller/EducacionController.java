/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Portfolio.controller;

import com.example.Portfolio.model.Educacion;
import com.example.Portfolio.service.IEducacionService;
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
public class EducacionController {
    
    @Autowired
    private IEducacionService eduServ;
    
    @GetMapping("educacion/ver")
    @ResponseBody
    public List<Educacion> verEducacion(){
        return eduServ.verEducacion();
    }
    
    @PostMapping("educacion/new")
    public void crearEducacion(@RequestBody Educacion e){
        eduServ.crearEducacion(e);
    }
    
    @PostMapping("educacion/modificar/{id}")
    public void modificarEducacion(@RequestBody Educacion e, @PathVariable Long id){
        eduServ.modificarEducacion(e, id);
    }
    
    
    @DeleteMapping("educacion/delete/{id}")
    public void borrarEducacion (@PathVariable Long id){
        eduServ.borrarEducacion(id);
    }
    
    
}
