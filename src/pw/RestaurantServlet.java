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
			case "INICIO":
				mandar=getServletContext().getRequestDispatcher("/index.html");
				break;
			
			case "Ubiquenos":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/ubicacion.jsp");
				break;
				
			case "Contactenos":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/contactenos.jsp");
				break;
				
			case "Reseña":
				mandar=getServletContext().getRequestDispatcher("");
				break;
				
			case "MENUS":
				mandar=getServletContext().getRequestDispatcher("");
				break;
				
			case "Entradas":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/entradas.jsp");
				break;
				
			case "Sopas":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/sopa.jsp");
				break;
				
			case "Ensaladas":
				mandar=getServletContext().getRequestDispatcher("");
				break;
				
			case "Plato De Fondo":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/platosfondo.jsp");
				break;
				
			case "Extras":
				mandar=getServletContext().getRequestDispatcher("");
				break;
				
			case "BEBIDAS":
				mandar=getServletContext().getRequestDispatcher("");
				break;
				
			case "Bebidas Alcoholicas":
				mandar=getServletContext().getRequestDispatcher("");
				break;
				
			case "Bibidas Gasificadas":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/bebidasgas.jsp");
				break;
				
			case "RESERVAR":
				mandar=getServletContext().getRequestDispatcher("");	
				break;
				
			case "Reservar Mesa":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/reservaMesa.jsp");
				break;
				
			case "Reservar Local":
				mandar=getServletContext().getRequestDispatcher("");
				break;
			
			case "LOGIN":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/login.jsp");	
				break;
				
			case "Registrarse":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/formCliente.jsp");
				break;
				
			default :
			 	mandar=getServletContext().getRequestDispatcher("/index.html");	
			break;
			}
			mandar.forward(req, resp);
	}
}
