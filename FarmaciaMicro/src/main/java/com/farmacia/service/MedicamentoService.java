package com.farmacia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmacia.model.Medicamento;
import com.farmacia.repository.IMedicamentoRepository;

@Service
public class MedicamentoService implements IMedicamentoService {

	@Autowired
	IMedicamentoRepository repository;
	
	@Override
	public List<Medicamento> findAll() {
		return repository.findAll();
	}

	@Override
	public Medicamento create(Medicamento obj) {
		return repository.save(obj);
	}

	@Override
	public Medicamento find(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public Medicamento update(Medicamento obj) {
		return repository.save(obj);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
		
	}

	@Override
	public Medicamento getMedicamentoByName(String nombre) throws Exception {
		return repository.getMedicamentoByName(nombre);
	}

}
