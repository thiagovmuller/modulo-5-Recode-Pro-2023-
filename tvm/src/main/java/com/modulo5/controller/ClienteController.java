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

import com.modulo5.entities.Cliente;
import com.modulo5.repositories.ClienteRepository;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("clientes/index.html");

		List<Cliente> clientes = clienteRepository.findAll();
		modelAndView.addObject("clientes", clientes);

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("clientes/cadastrar.html");

		modelAndView.addObject("cliente", new Cliente());

		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Cliente cliente) throws IOException {

		ModelAndView modelAndView = new ModelAndView("redirect:/clientes");

		clienteRepository.save(cliente);

		return modelAndView;
	}

//	@GetMapping("/{idCliente}/editar")
//	public ModelAndView editar(@PathVariable Long idCliente) {
//		ModelAndView modelAndView = new ModelAndView("clientes/atualizar.html");
//
//		Cliente cliente = clienteRepository.getReferenceById(idCliente);
////		System.out.println("#########");
//////		System.out.println(cliente);
////		System.out.println(idCliente);
//		modelAndView.addObject("cliente", cliente);
//		
//
//		return modelAndView;
//	}
	
	@GetMapping("/{idCliente}/editar")
	public ModelAndView editar(@PathVariable Long idCliente) {
	    ModelAndView modelAndView = new ModelAndView("clientes/atualizar.html");
	    
	    Cliente cliente = clienteRepository.findById(idCliente).orElse(null);
	    modelAndView.addObject("cliente", cliente);

	    return modelAndView;
	}

	@PostMapping("/{idCliente}/editar")
	public ModelAndView editar(Cliente cliente) {

		clienteRepository.save(cliente);
		ModelAndView modelAndView = new ModelAndView("redirect:/clientes");

		return modelAndView;
	}

	@GetMapping("/{idCliente}/excluir")
	public ModelAndView excluir(@PathVariable Long idCliente) {
		ModelAndView modelAndView = new ModelAndView("redirect:/clientes");

		clienteRepository.deleteById(idCliente);

		return modelAndView;
	}

}
