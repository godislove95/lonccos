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
				try{
					
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/menuEntradas.jsp");
					rd.forward(req, resp);
				}catch(Exception e){
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				}
				break;
			
			case "sopa":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/menuSopas.jsp");
				break;
				
			case "fondo":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/menuPlatoFondo.jsp");
				break;
				
			case "ensalada":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/menuEnsaladas.jsp");
				break;
				
			case "postre":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/menuPostres.jsp");
				break;
				
			case "extra":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/menuExtras.jsp");
				break;
				
			case "bebida":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/menuBebidas.jsp");
				break;
			
			default :
			 	mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp");	
			break;
			}
			mandar.forward(req, resp);
	}
}
