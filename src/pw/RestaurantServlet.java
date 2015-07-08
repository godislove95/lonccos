package pw;

import java.util.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class RestaurantServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher mandar = null ;
			
			String rest=req.getParameter("rest");
			switch (rest){
			case "inicio":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/inicio.jsp");
				break;
			
			case "nosotros":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/nosotros.jsp");
				break;
				
			case "menu":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/menu.jsp");
				break;
				
			case "ofertas":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/ofertas.jsp");
				break;
				
			case "locales":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/locales.jsp");
				break;
				
			case "eventos":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/eventos.jsp");
				break;
				
			case "reservas":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/reservas.jsp");
				break;
				
			case "ingresar":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/ingresar.jsp");
				break;
				
			case "registro":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/registro.jsp");
				break;
				
			case "registrarse":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/registrarse.jsp");
				break;
				
			default :
			 	mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/inicio.jsp");	
			break;
			}
			mandar.forward(req, resp);
	}
}
