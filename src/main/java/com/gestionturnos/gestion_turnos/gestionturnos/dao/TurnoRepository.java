package com.gestionturnos.gestion_turnos.gestionturnos.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionturnos.gestion_turnos.gestionturnos.model.Medico;
import com.gestionturnos.gestion_turnos.gestionturnos.model.Paciente;
import com.gestionturnos.gestion_turnos.gestionturnos.model.Turno;
/**
 * 
 * @author flor
 *
 */
@Repository
public interface TurnoRepository extends JpaRepository<Turno, Integer> {
	
	Optional<Turno> findById(Integer idTurno);
		
	List<Turno> findByPaciente(Paciente paciente);

	List<Turno> findByMedico(Medico medico);
	
}
