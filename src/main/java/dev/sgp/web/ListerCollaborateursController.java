package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.util.Constantes;

@WebServlet(urlPatterns = { "/collaborateurs/lister" })
public class ListerCollaborateursController extends HttpServlet {

	// recuperation du service qui contient la liste des collaborateurs
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	// recuperation du service qui contient la liste DES departmentS
	private DepartementService departService = Constantes.DEPT_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// utilisation du service collaborateur
		List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();

		req.setAttribute("listeCollaborateur", collaborateurs);
		// service departemnet
    
		req.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp").forward(req, resp);

	}
}