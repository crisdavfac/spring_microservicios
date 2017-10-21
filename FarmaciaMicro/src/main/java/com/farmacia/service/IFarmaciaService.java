package com.farmacia.service;

import java.util.List;


import com.farmacia.model.Farmacia;

public interface IFarmaciaService extends CRUD<Farmacia> {
	
	List<Farmacia> getFarmaciaByIdMedicamento( Integer idMedicamento)throws Exception;

}
