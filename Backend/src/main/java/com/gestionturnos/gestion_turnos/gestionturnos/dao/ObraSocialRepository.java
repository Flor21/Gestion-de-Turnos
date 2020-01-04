package com.gestionturnos.gestion_turnos.gestionturnos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestionturnos.gestion_turnos.gestionturnos.model.ObraSocial;
import java.util.Optional;

/**
 * 
 * @author flor
 *
 */
public interface ObraSocialRepository extends JpaRepository<ObraSocial, String> {
	
	Optional<ObraSocial> findById(String idObraSocial);
	/*
		
	Set<ObraSocial> findByMedico(Medico medico);
*/
}
