package com.farmacia.service;

import com.farmacia.model.Medicamento;

public interface IMedicamentoService extends CRUD<Medicamento> {
	
	Medicamento getMedicamentoByName(String nombre)throws Exception;

}
