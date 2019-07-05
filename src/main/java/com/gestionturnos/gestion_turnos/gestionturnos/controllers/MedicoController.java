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
import com.gestionturnos.gestion_turnos.gestionturnos.model.Medico;

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
	
	@GetMapping("/especialidad/{especialidad}")
	public ResponseEntity<Set<Medico>> findByEspecialidad(@PathVariable String especialidad) {
		Set<Medico> esp = repository.findByEspecialidad(especialidad);
		return ResponseEntity.ok(esp);
	}

	@PostMapping()
	public ResponseEntity<Medico> create(@Valid @RequestBody Medico createRequest) {
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
