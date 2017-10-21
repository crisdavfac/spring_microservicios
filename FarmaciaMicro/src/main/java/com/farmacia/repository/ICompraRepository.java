package com.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.model.Compra;

public interface ICompraRepository extends JpaRepository<Compra, Integer> {

}
