package com.gestionturnos.gestion_turnos.gestionturnos.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionturnos.gestion_turnos.gestionturnos.dao.ObraSocialRepository;
import com.gestionturnos.gestion_turnos.gestionturnos.dao.PacienteRepository;
import com.gestionturnos.gestion_turnos.gestionturnos.dao.TurnoRepository;
import com.gestionturnos.gestion_turnos.gestionturnos.model.ObraSocial;
import com.gestionturnos.gestion_turnos.gestionturnos.model.Paciente;
import com.gestionturnos.gestion_turnos.gestionturnos.model.Turno;

/**
 * 
 * @author flor
 *
 */
@RestController
@RequestMapping("/paciente")
public class PacienteController {
	
	@Autowired
	private PacienteRepository repository;
			
	@Autowired
	private ObraSocialRepository obraSocialRepository;

	@Autowired
	private TurnoRepository turnoRepository;
	
	@GetMapping()
	public Page<Paciente> getPage(Pageable pageable) {
		return repository.findAll(pageable);
	}
		
	@GetMapping("/{idPaciente}")
	public ResponseEntity<Paciente> findById(@PathVariable Integer idPaciente) {
		
		Optional<Paciente> opt = repository.findById(idPaciente);
		if (opt.isPresent())
			return ResponseEntity.ok(opt.get());
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/dni/{dni}")
	public ResponseEntity<Paciente> findByDni(@PathVariable Integer dni) {

		Optional<Paciente> opt = repository.findByDni(dni);
		if (opt.isPresent())
			return ResponseEntity.ok(opt.get());
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/obraSocial/{idObraSocial}")
	public ResponseEntity<Set<Paciente>> findByObraSocial(@PathVariable Integer idObraSocial) {
		ObraSocial obraSocial = obraSocialRepository.getOne(idObraSocial);
		Set<Paciente> ret = repository.findByObraSocial(obraSocial);
		return ResponseEntity.ok(ret);
	}
	
	





	/*@GetMapping("/turno/{idTurno}")
	public ResponseEntity<Set<Paciente>> findByTurno(@PathVariable Integer idTurno) {
		Turno turnos = turnoRepository.getOne(idTurno);
		Set<Paciente> ret = repository.findByTurno(turnos);
		return ResponseEntity.ok(ret);
	}*/
	
	@PostMapping()
	public ResponseEntity<Paciente> create(@Valid @RequestBody Paciente createRequest) {
		//System.out.println(createRequest.getObraSocial());
		var obra = createRequest.getObraSocial();
		var result = obraSocialRepository.findById(obra.getIdObraSocial());
		if (result.isEmpty()){
			createRequest.setObraSocial(null);
		}
		return ResponseEntity.ok(repository.save(createRequest));
	}
	
	@PutMapping()
	public ResponseEntity<Paciente> update(@Valid @RequestBody Paciente updateRequest) {
		boolean exists = repository.existsById(updateRequest.getIdPaciente());
		if (exists) {
			return ResponseEntity.ok(repository.save(updateRequest));
		}
		return ResponseEntity.notFound().build();		
	}
	
	@DeleteMapping("/{idPaciente}")
	public ResponseEntity<Paciente> delete(@PathVariable Integer idPaciente) {
		Optional<Paciente> opt = repository.findById(idPaciente);
		if (opt.isPresent()) {
			repository.delete(opt.get());
			return ResponseEntity.ok().build();			
		}
		return ResponseEntity.notFound().build();
	}
}
