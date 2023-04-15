package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IProduitDao;
import dao.ProduitDaoImpl;
import dao.entities.Produit;

@WebServlet(urlPatterns = {"/index.do","/rechercher.do","/saisie.do","/save.do","/supprimer.do","/editer.do","/editSave.do"})
public class ServletControleur extends HttpServlet{
	IProduitDao metier;
	@Override
	public void init() throws ServletException {
		metier=new ProduitDaoImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		if(path.equals("/index.do")) {
			request.getRequestDispatcher("affichage.jsp").forward(request, response);
		}
		if(path.equals("/rechercher.do")) {
			ProduitModel model=new ProduitModel();
			String motCle=request.getParameter("motCle");
			model.setMotCle(motCle);
			model.setProduits(metier.rechercherParMotCle("%"+motCle+"%"));
			request.setAttribute("model", model);
			request.getRequestDispatcher("affichage.jsp").forward(request, response);
		}
		
		if(path.equals("/saisie.do")) {
			Produit produit=new Produit();
			request.setAttribute("produit", produit);
			request.getRequestDispatcher("saisie.jsp").forward(request, response);
		}
		
		if(path.equals("/save.do") && request.getMethod().equals("POST")) {
			String designation=request.getParameter("designation");
			double prix=Double.parseDouble(request.getParameter("prix"));
			int quantite=Integer.parseInt(request.getParameter("quantite"));
			Produit produit=metier.save(new Produit(designation,prix,quantite));
			request.setAttribute("produit", produit);
			request.getRequestDispatcher("save.jsp").forward(request, response);
		}
		
		if(path.equals("/supprimer.do")) {
			int id=Integer.parseInt(request.getParameter("id"));
			metier.supprimer(id);
			response.sendRedirect("rechercher.do?motCle=");
		}
		
		if(path.equals("/editer.do")) {
			int id=Integer.parseInt(request.getParameter("id"));
			Produit produit=metier.getProduit(id);
			request.setAttribute("produit", produit);
			request.getRequestDispatcher("editer.jsp").forward(request, response);
		}
		
		if(path.equals("/editSave.do") && request.getMethod().equals("POST")) {
			int id=Integer.parseInt(request.getParameter("id"));
			String designation=request.getParameter("designation");
			double prix=Double.parseDouble(request.getParameter("prix"));
			int quantite=Integer.parseInt(request.getParameter("quantite"));
			metier.editer(new Produit(id, designation, prix, quantite));
			response.sendRedirect("rechercher.do?motCle=");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	

}
