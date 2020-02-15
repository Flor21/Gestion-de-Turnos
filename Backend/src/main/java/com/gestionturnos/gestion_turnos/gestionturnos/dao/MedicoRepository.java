package com.gestionturnos.gestion_turnos.gestionturnos.dao;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionturnos.gestion_turnos.gestionturnos.model.Medico;

/**
 * 
 * @author flor
 *
 */
@Repository
public interface MedicoRepository extends JpaRepository<Medico, String>{
	
	Optional<Medico> findById(String idMedico);
	
	Optional<Medico> findByMatricula(Integer matricula);

	Set<Medico> findByEspecialidad(String especialidad);
		
}
