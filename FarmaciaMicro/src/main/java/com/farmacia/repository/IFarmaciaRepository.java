package com.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.farmacia.model.Farmacia;

@Repository
public interface IFarmaciaRepository extends JpaRepository<Farmacia, Integer>{
	 
	@Query("from farmacia f where f.medicamento.id = :idMedicamento")
	List<Farmacia> getFarmaciaByIdMedicamento(@Param("idMedicamento") Integer idMedicamento)throws Exception;

}
