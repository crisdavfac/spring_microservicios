package com.farmacia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmacia.model.Farmacia;
import com.farmacia.repository.IFarmaciaRepository;

@Service
public class FarmaciaService implements IFarmaciaService {

	@Autowired
	IFarmaciaRepository repository;
	
	@Override
	public List<Farmacia> findAll() {
		return repository.findAll();
	}

	@Override
	public Farmacia create(Farmacia obj) {
		return repository.save(obj);
	}

	@Override
	public Farmacia find(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public Farmacia update(Farmacia obj) {
		return repository.save(obj);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
		
	}

	@Override
	public List<Farmacia> getFarmaciaByIdMedicamento(Integer idMedicamento) throws Exception {
		return repository.getFarmaciaByIdMedicamento(idMedicamento);
	}

}
