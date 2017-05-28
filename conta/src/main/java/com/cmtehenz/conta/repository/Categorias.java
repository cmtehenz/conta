package com.cmtehenz.conta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmtehenz.conta.model.Categoria;

public interface Categorias extends JpaRepository<Categoria, Long> {

} 
