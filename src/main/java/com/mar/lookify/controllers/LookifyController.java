//Marcelo Aceituno R
//Full Stack Java 0034
//Lookify
package com.mar.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mar.lookify.models.Lookify;
import com.mar.lookify.services.LookifyService;

@Controller
public class LookifyController {
	
	private final LookifyService lookifyService;
    
    public LookifyController(LookifyService lookifyService) {
        this.lookifyService = lookifyService;
    } 
    
    @RequestMapping("/")
    public String inicio() {    	
    	return "index.jsp";
	}    
    
    //mostrar
    @RequestMapping("/dashboard")
	public String inicio(@ModelAttribute("canciones") Lookify lookify, Model model) {
		List<Lookify> canciones = lookifyService.allLookify();
		model.addAttribute("canciones", canciones);
	return "dashboard.jsp";
	}
   	
    //crear nuevo 
    
    @RequestMapping("/songs/new")
    public String newBook(@ModelAttribute("cancion") Lookify lookify) {
        return "nuevo.jsp";
    }
    
    @RequestMapping(value="/songs/new", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("cancion") Lookify lookify, BindingResult result) {
        if (result.hasErrors()) {
            return "/nuevo.jsp";
        } else {
            lookifyService.createLookify(lookify);
            return "redirect:/songs/new";
        }
    }   
    
    //mostrar por id
    @RequestMapping("songs/{id}")
	public String mostrar(@PathVariable("id") Long id, Model model) {
	     Lookify cancion = lookifyService.findLookify(id);
	     model.addAttribute("cancion", cancion);
	return "/show.jsp";
	}   
    
    //eliminar 
    @RequestMapping("/songs/delete/{id}")
    public String borra(@PathVariable("id") Long id, Model model) {
        Lookify canciones = lookifyService.findLookify(id);
        model.addAttribute("canciones", canciones);
        lookifyService.deleteLookify(id);
    return "redirect:/dashboard";
    }  	

}
