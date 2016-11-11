/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf.controladores;

import com.ues.igf.modelos.Inmueble;
import com.ues.igf.repositorios.InmuebleRepositorio;
import java.util.List;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kevin
 */
@RestController
@RequestMapping("/api")
public class InmuebleController {
    
    @Inject
    InmuebleRepositorio inmuebleRepositorio;
    
    
    @RequestMapping(value="/inmuebles", method=RequestMethod.GET)
    public List<Inmueble> contribuyentes(){
        return inmuebleRepositorio.findAll();
    }
    
    @RequestMapping(value="/inmuebles", method=RequestMethod.POST)
    public Inmueble savecontribuyentes(@RequestBody Inmueble inmueble){
        return inmuebleRepositorio.save(inmueble);
    }
    
    @RequestMapping(value="/inmuebles/{id}", method=RequestMethod.GET)
    public Inmueble getInmueble(@PathVariable String id){
        return inmuebleRepositorio.findOne(id);
    }
    
    @RequestMapping(value="/inmuebles/{id}", method=RequestMethod.PUT)
    public Inmueble updateInmueble(@RequestBody Inmueble inmueble, @PathVariable String id){
        return inmuebleRepositorio.save(inmueble);
    }
    

}
