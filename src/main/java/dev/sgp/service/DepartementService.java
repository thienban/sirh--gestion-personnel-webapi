package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import dev.sgp.entite.Departement;

public class DepartementService {
	private List<Departement> departements = new ArrayList<>();

	public List<Departement> listerDepartements() {
		return departements;
	}

	public void ajouterDepartement(Departement dept) {
		departements.add(dept);
	}

}
