package com.farmacia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.farmacia.model.Compra;
import com.farmacia.repository.ICompraRepository;

@Repository
public class CompraService implements ICompraService {
	
	@Autowired
	ICompraRepository repository;

	@Override
	public List<Compra> findAll() {
		return repository.findAll();
	}

	@Override
	public Compra create(Compra obj) {
		return repository.save(obj);
	}

	@Override
	public Compra find(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public Compra update(Compra obj) {
		return repository.save(obj);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
		
	}
	

}
