package pw;

import java.util.*;
import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class MenuServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher mandar = null ;
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		String rest=req.getParameter("rest");
		
		switch (rest){
		case "entrada":
			Query q0 = pm.newQuery(Plato.class);
			q0.setFilter("tipo == tipoParam");
			q0.declareParameters("String tipoParam");
				@SuppressWarnings("unchecked")
				List<Plato> entrada = (List<Plato>) q0.execute("ad_entrada");
				req.setAttribute("lista", entrada);
			mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/menuEntrada.jsp");
			break;
		
		case "sopa":
			Query q1 = pm.newQuery(Plato.class);
			q1.setFilter("tipo == tipoParam");
			q1.declareParameters("String tipoParam");
			@SuppressWarnings("unchecked")
			List<Plato> sopa = (List<Plato>) q1.execute("ad_sopa");
			req.setAttribute("lista", sopa);
			mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/menuSopa.jsp");
			break;
			
		case "fondo":
			Query q2 = pm.newQuery(Plato.class);
			q2.setFilter("tipo == tipoParam");
			q2.declareParameters("String tipoParam");
			@SuppressWarnings("unchecked")
			List<Plato> fondo = (List<Plato>) q2.execute("ad_fondo");
			req.setAttribute("lista", fondo);
			mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/menuFondo.jsp");
			break;
			
		case "ensalada":
			Query q3 = pm.newQuery(Plato.class);
			q3.setFilter("tipo == tipoParam");
			q3.declareParameters("String tipoParam");
			@SuppressWarnings("unchecked")
			List<Plato> ensalada = (List<Plato>) q3.execute("ad_ensalada");
			req.setAttribute("lista", ensalada);
			mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/menuEnsalada.jsp");
			break;
			
		case "postre":
			Query q4 = pm.newQuery(Plato.class);
			q4.setFilter("tipo == tipoParam");
			q4.declareParameters("String tipoParam");
			@SuppressWarnings("unchecked")
			List<Plato> postre = (List<Plato>) q4.execute("ad_postre");
			req.setAttribute("lista", postre);
			mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/menuPostre.jsp");
			break;
			
		case "extra":
			Query q5 = pm.newQuery(Plato.class);
			q5.setFilter("tipo == tipoParam");
			q5.declareParameters("String tipoParam");
			@SuppressWarnings("unchecked")
			List<Plato> extra = (List<Plato>) q5.execute("ad_extra");
			req.setAttribute("lista", extra);
			mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/menuExtra.jsp");
			break;
			
		case "bebida":
			Query q6 = pm.newQuery(Bebida.class);
			@SuppressWarnings("unchecked")
			List<Bebida> bebida = (List<Bebida>) q6.execute();
			req.setAttribute("lista", bebida);
			mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/menuBebida.jsp");
			break;
			
			default :
			 	mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp");	
			break;
			}
			mandar.forward(req, resp);
	}
}
