package dev.sgp.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateursController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// recupere la valeur d'un parametre
		String matricule = req.getParameter("matricule");

		if (matricule == null || matricule.equals("")) {
			resp.sendError(400, "un matricule est attendu");
		} else {
			resp.setContentType("text/html");
			resp.getWriter().write(
					"<h1>Edition des collaborateurs</h1>" + "<ul>" + "<li>Matricule=" + matricule + "</li>" + "</ul>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * String matricule = req.getParameter("matricule"); String titre =
		 * req.getParameter("titre"); String nom = req.getParameter("nom"); String
		 * prenom = req.getParameter("prenom"); StringBuffer message = new StringBuffer
		 * ("Les paramètres suivants sont incorrects : ");
		 * 
		 * ArrayList<String> missing = new ArrayList<>();
		 * 
		 * if (matricule == null || matricule.equals("")){ missing.add("matricule"); }
		 * if (titre == null || titre.equals("")){ missing.add("titre"); } if (nom ==
		 * null || nom.equals("")){ missing.add("nom"); } if (prenom == null ||
		 * prenom.equals("")){ missing.add("prenom"); }
		 * resp.setContentType("text/html");
		 * 
		 * if (missing.size() > 0) { for (String m : missing) {
		 * message.append(m).append(", "); } resp.sendError(400, message.toString()); }
		 * else { resp.setContentType("text/html"); resp.getWriter()
		 * .write("<h1>Edition des collaborateurs</h1>" + "<ul>" + "<li>Matricule=" +
		 * matricule + "</li>" + "<li>Titre=" + titre + "</li>" + "<li>Nom=" + nom +
		 * "</li>" + "<li>Prenom=" + prenom + "</li>" + "</ul>");
		 */
		resp.sendRedirect(req.getContextPath() + "/collaborateurs/editer");
	}
}