/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ues.igf.repositorios;

import com.ues.igf.modelos.Contribuyente;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author kevin
 */


public interface ContribuyenteRepositorio extends JpaRepository<Contribuyente, Integer>{
    
}
