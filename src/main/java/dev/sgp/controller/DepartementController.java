package dev.sgp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.sgp.entite.Departement;
import dev.sgp.repository.DepartementRepository;

@RestController
@RequestMapping("/departements")
public class DepartementController {
	@Autowired
	private DepartementRepository departRepo;

	@GetMapping
	public List<Departement> listerdepartements() {
		return this.departRepo.findAll();
	}
}