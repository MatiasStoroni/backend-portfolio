/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Portfolio.controller;

import com.example.Portfolio.model.Proyecto;
import com.example.Portfolio.service.IProyectoService;
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
public class ProyectoController {
    
    @Autowired
    private IProyectoService proyServ;
    
    @GetMapping("proyecto/ver")
    @ResponseBody
    public List<Proyecto> verProyecto(){
        return proyServ.verProyecto();
    }
    
    @PostMapping("proyecto/new")
    public void crearProyecto(@RequestBody Proyecto p){
        proyServ.crearProyecto(p);
    }
    
    @PostMapping("proyecto/modificar/{id}")
    public void modificarProyecto(@RequestBody Proyecto p, @PathVariable Long id){
        proyServ.modificarProyecto(p, id);
    }
    
    
    @DeleteMapping("proyecto/delete/{id}")
    public void borrarProyecto (@PathVariable Long id){
        proyServ.borrarProyecto(id);
    }
    
    
}
