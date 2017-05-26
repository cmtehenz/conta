package com.cmtehenz.conta.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cmtehenz.conta.model.Lancamento;

public interface Lancamentos extends JpaRepository<Lancamento, Long> {

}
