package com.mar.lookify.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mar.lookify.models.Lookify;
import com.mar.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	
	private final LookifyRepository lookifyRepository;
    
	 public LookifyService(LookifyRepository lookifyRepository) {
	    this.lookifyRepository = lookifyRepository;
	 }
	 
	 //Devolviendo todos los ....
	 public List<Lookify> allLookify() {
	    return lookifyRepository.findAll();
	 }
	 
	 //Creando un libro.
	 public Lookify createLookify(Lookify b) {
	    return lookifyRepository.save(b);
	 }
	 
	 //Obteniendo la información de un ID
	 public Lookify findLookify(Long id) {
	    Optional<Lookify> optional = lookifyRepository.findById(id);
	    if(optional.isPresent()) {
	        return optional.get();
	    } else {
	        return null;
	    }
	 }
	    
	 //Elimina un registro por ID
	 public void deleteLookify(Long id ) {	    	
		 lookifyRepository.deleteById(id);
	 }

}
