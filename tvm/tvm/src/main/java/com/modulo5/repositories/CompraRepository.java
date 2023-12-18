package com.modulo5.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.modulo5.entities.Compra;

	public interface CompraRepository extends JpaRepository<Compra, Long> {

	}
