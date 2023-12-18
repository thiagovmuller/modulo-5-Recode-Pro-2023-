package com.modulo5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modulo5.entities.Passagem;

public interface PassagemRepository extends JpaRepository<Passagem, Long> {

}