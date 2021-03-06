/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf.controladores;

import com.ues.igf.modelos.Contribuyente;
import com.ues.igf.repositorios.ContribuyenteRepositorio;
import java.util.List;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kevin
 */
@RestController
@RequestMapping("/api")
public class ContribuyenteController {
    
    @Inject
    private ContribuyenteRepositorio contribuyenteRepositorio;
    
    
    @RequestMapping(value="/contribuyentes", method=RequestMethod.GET)
    public List<Contribuyente> contribuyentes(){
        return contribuyenteRepositorio.findAll();
    }
    
    @RequestMapping(value="/contribuyentes", consumes="application/json", method=RequestMethod.POST)
    public @ResponseBody Contribuyente saveContribuyente(@RequestBody Contribuyente contribuyente){
        return contribuyenteRepositorio.save(contribuyente);
    }
    
    @RequestMapping(value="/contribuyentes/{contribId}", method=RequestMethod.GET)
    public @ResponseBody Contribuyente contribuyentePorId(@PathVariable Integer contribId){
        return contribuyenteRepositorio.findOne(contribId);
    }
    
    
    
}
