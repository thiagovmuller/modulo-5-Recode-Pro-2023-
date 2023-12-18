package com.modulo5.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.modulo5.entities.Passagem;
import com.modulo5.repositories.PassagemRepository;

@Controller
@RequestMapping("/passagens")
public class PassagemController {
	@Autowired
    private PassagemRepository passagemRepository;
	
	@GetMapping
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("passagens/index.html");

        List<Passagem> passagem = passagemRepository.findAll();
        modelAndView.addObject("passagens", passagem);

        return modelAndView;
    }
	
	@GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        ModelAndView modelAndView = new ModelAndView("passagens/cadastro"); 

        modelAndView.addObject("destino", new Passagem());

        return modelAndView;
    }
	
	@PostMapping("/cadastrar")
    public ModelAndView cadastrar(Passagem passagem) throws IOException {

        ModelAndView modelAndView = new ModelAndView("redirect:/passagens");

        passagemRepository.save(passagem);

        return modelAndView;
    }
	
	@GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("passagens/atualizar");

        Passagem passagem = passagemRepository.getReferenceById(id);
        modelAndView.addObject("passagem", passagem);

        return modelAndView;
    }
    
    @PostMapping("/{id}/editar")
    public ModelAndView editar(Passagem passagem)  {


    	passagemRepository.save(passagem);
        ModelAndView modelAndView = new ModelAndView("redirect:/passagens");

        return modelAndView;
    }
	
    
    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/passagens");

        passagemRepository.deleteById(id);

        return modelAndView;
    }
    
}