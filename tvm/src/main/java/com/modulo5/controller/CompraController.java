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
import com.modulo5.entities.Compra;
import com.modulo5.entities.Passagem;
import com.modulo5.repositories.ClienteRepository;
import com.modulo5.repositories.CompraRepository;
import com.modulo5.repositories.PassagemRepository;

@Controller
@RequestMapping("/compras")
public class CompraController {

	@Autowired
	private CompraRepository compraRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PassagemRepository passagemRepository;

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("compras/index.html");

		List<Compra> compras = compraRepository.findAll();
		modelAndView.addObject("compras", compras);
		
		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("compras/cadastrar.html");

		modelAndView.addObject("compra", new Compra());
		modelAndView.addObject("cliente", clienteRepository.findAll());
		modelAndView.addObject("passagem", passagemRepository.findAll());


		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Compra compra) throws IOException {

		compraRepository.save(compra);
		ModelAndView modelAndView = new ModelAndView("redirect:/compras");

		
		return modelAndView;
	}
	
	
//	@GetMapping("/{idCompra}/editar")
//    public ModelAndView editar(@PathVariable Long idCompra) {
//        ModelAndView modelAndView = new ModelAndView("compras/atualizar.html");
////      Long idCompraLong = Long.parseLong(idCompra);
////        double d = Double.valueOf(idCompra);
////        long idCompraLong = (long) d;
//        modelAndView.addObject(compraRepository.getReferenceById(idCompra));
//        modelAndView.addObject("clientes", clienteRepository.findAll());
//		modelAndView.addObject("passagens", passagemRepository.findAll());
//        
//        return modelAndView;
//    }
	
	@GetMapping("/{idCompra}/editar")
	public ModelAndView editar(@PathVariable Long idCompra) {
	    ModelAndView modelAndView = new ModelAndView("compras/atualizar.html");
	    
	    Compra compra = compraRepository.findById(idCompra).orElse(null);
	    List<Cliente> clientes = clienteRepository.findAll();
	    List<Passagem> passagens = passagemRepository.findAll();

	    modelAndView.addObject("compra", compra);
	    modelAndView.addObject("clientes", clientes);
	    modelAndView.addObject("passagens", passagens);

	    return modelAndView;
	}

	
	@PostMapping("/{idCompra}/editar")
    public ModelAndView editar(Compra compra)  {


		compraRepository.save(compra);
        ModelAndView modelAndView = new ModelAndView("redirect:/compras");

        return modelAndView;
    }

	 @GetMapping("/{idCompra}/excluir")
	    public ModelAndView excluir(@PathVariable Long idCompra) {
	        ModelAndView modelAndView = new ModelAndView("redirect:/compras");

	        compraRepository.deleteById(idCompra);

	        return modelAndView;
	    }
//	 @GetMapping("/{idCompra}/excluir")
//	 public ModelAndView excluir(@PathVariable("idCompra") Long idCompra) {
//	     ModelAndView modelAndView = new ModelAndView("redirect:/compras");
//
//	     // Seu código para excluir a compra
//
//	     return modelAndView;
//	 }

	
}
