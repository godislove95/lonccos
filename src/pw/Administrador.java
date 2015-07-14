package pw;
import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Administrador extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher mandar = null ;
		HttpSession session = req.getSession();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Query q = pm.newQuery(Usuario.class);
			q.setFilter("admin == adminParam");
			q.declareParameters("Integer adminParam");
			List<Usuario> administradores = (List<Usuario>)q.execute(1);
			
			String rest=req.getParameter("admin");
			
			switch (rest){
			case "admin":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/opciones_admin.jsp");
				break;
			
			case "menu":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/opciones_menus.jsp");
				break;
				
			case "bebida":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/opciones_bebida.jsp");
				break;
				
			case "reserva":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/opciones_reserva.jsp");
				break;
				
			case "cliente":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/opciones_clientes.jsp");
				break;
				
			case "agregarAdmin":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/agregarAdmin.jsp");
				break;
				
			case "borrarAdmin":
				req.setAttribute("lista", administradores);
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/borrarAdmin.jsp");
				break;
				
			case "mostrarAdmin":
				req.setAttribute("lista", administradores);
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/mostrarAdmin.jsp");
				break;
				
			default :
			 	mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/opciones_admin.jsp");	
			break;
			}
			mandar.forward(req, resp);
	}
}