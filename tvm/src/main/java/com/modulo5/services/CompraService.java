package com.modulo5.services;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.modulo5.entities.Compra;
import com.modulo5.repositories.CompraRepository;

@Service
public class CompraService {

    private final CompraRepository compraRepository = null;

    // Injeção de dependência do CompraRepository (construtor ou @Autowired)

    @Transactional(readOnly = true)
    public Compra findById(Long idCompra) {
        Compra compra = compraRepository.findById(idCompra).orElse(null);
        
        // Certifique-se de que a entidade cliente seja carregada antes de sair do método
        Hibernate.initialize(compra.getCliente());
        
        return compra;
    }
}
