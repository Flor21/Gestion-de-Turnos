package com.gestionturnos.gestion_turnos.gestionturnos.controllers;

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

import com.gestionturnos.gestion_turnos.gestionturnos.dao.MedicoRepository;
//import com.gestionturnos.gestion_turnos.gestionturnos.dao.Repository;
import com.gestionturnos.gestion_turnos.gestionturnos.model.Medico;
//import com.gestionturnos.gestion_turnos.gestionturnos.model.ObraSocial;

/**
 * 
 * @author flor
 *
 */
@RestController
@RequestMapping("/medico")
public class MedicoController {
	
	@Autowired
	private MedicoRepository repository;
	
	//@Autowired
	//private ObraSocialRepository obraSocialRepository;
	
	@GetMapping()
	public Page<Medico> getPage(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@GetMapping("/{idMedico}")
	public ResponseEntity<Medico> findById(@PathVariable Integer idMedico) {
		
		Optional<Medico> opt = repository.findById(idMedico);
		if (opt.isPresent())
			return ResponseEntity.ok(opt.get());
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/matricula/{matricula}")
	public ResponseEntity<Medico> findByNroMatricula(@PathVariable Integer matricula) {
		Optional<Medico> opt = repository.findByMatricula(matricula);
		if (opt.isPresent())
			return ResponseEntity.ok(opt.get());
		return ResponseEntity.notFound().build();
	}
	
//	@GetMapping("/obraSocial/{idObraSocial}")
//	public ResponseEntity<Set<Medico>> findByObraSociales(@PathVariable Integer idObraSocial) {
//		ObraSocial obraSocial = obraSocialRepository.getOne(idObraSocial);
//		Set<Medico> ret = repository.findByObraSociales(obraSocial);
//		return ResponseEntity.ok(ret);o
//	}
	/*
	@GetMapping("/especialidad/{especialidad}/obraSocial/{idObraSocial}")
	public ResponseEntity<Set<Medico>> findByEspecialidadAndObraSocial(@PathVariable String especialidad,
	@PathVariable Integer idObraSocial) {
		ObraSocial obraSocial = obraSocialRepository.getOne(idObraSocial);
		Set<Medico> ret = repository.findByEspecialidadAndObraSocial(especialidad, obraSocial);
		return  ResponseEntity.ok(ret);
	}
	*/
	/*
	 * @GetMapping("/turno/{idTurno}") public ResponseEntity<Set<Medico>>
	 * findByTurno(@PathVariable Integer idTurno) { Turno turno =
	 * turnoRepository.getOne(idTurno); Set<Medico> ret =
	 * repository.findByTurno(turno); return ResponseEntity.ok(ret); }
	 */

	@GetMapping("/especialidad/{especialidad}")
	public ResponseEntity<Set<Medico>> findByEspecialidad(@PathVariable String especialidad) {
		Set<Medico> esp = repository.findByEspecialidad(especialidad);
		return ResponseEntity.ok(esp);
	}

	@PostMapping()
	public ResponseEntity<Medico> create(@Valid @RequestBody Medico createRequest) {
		/*var medico = createRequest.getObraSociales();
		var result = obraSocialRepository.findById(medico.getIdObraSociales());
		if (result.isEmpty()){
			createRequest.setObraSocial(null);
		}
		ObraSocial os = obraSocialRepository.getOne(20);
	createRequest.getObraSociales().remove(createRequest.getObraSociales().get(0));
		createRequest.getObraSociales().add(os);
		System.out.println(createRequest.getObraSocial());
		createRequest.getObraSocial().add(os);
		Medico saved = repository.save(createRequest);
		return ResponseEntity.ok(saved);*/
		return ResponseEntity.ok(repository.save(createRequest));

	}
	
	@PutMapping()
	public ResponseEntity<Medico> update(@Valid @RequestBody Medico updateRequest) {
		boolean exists = repository.existsById(updateRequest.getIdMedico());
		if (exists) {
			return ResponseEntity.ok(repository.save(updateRequest));
		}
		return ResponseEntity.notFound().build();		
	}
	
	@DeleteMapping("/{idMedico}")
	public ResponseEntity<?> delete(@PathVariable Integer idMedico) {
		Optional<Medico> opt = repository.findById(idMedico);
		if (opt.isPresent()) {
			repository.delete(opt.get());
			return ResponseEntity.ok().build();			
		}
		return ResponseEntity.notFound().build();
}
	
	
}
