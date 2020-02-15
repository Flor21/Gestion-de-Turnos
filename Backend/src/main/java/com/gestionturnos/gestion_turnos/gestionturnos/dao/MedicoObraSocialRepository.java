package com.gestionturnos.gestion_turnos.gestionturnos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.gestionturnos.gestion_turnos.gestionturnos.model.MedicoObraSocial;


/**
 * 
 * @author flor
 *
 */

@Repository
public interface MedicoObraSocialRepository extends JpaRepository<MedicoObraSocial, String>{
	
	List<MedicoObraSocial> findByIdMedico(String idMedico);
	List<MedicoObraSocial> findByIdObraSocial(String idObraSocial);
					
}