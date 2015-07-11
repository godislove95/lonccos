package pw;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class CambioServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher mandar = null ;
		HttpSession session = req.getSession();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Usuario.class);
			String rest=req.getParameter("rest");
			q.setFilter("email == emailParam");
			q.declareParameters("String emailParam");
			List<Usuario> cliente= (List<Usuario>)q.execute(session.getAttribute("email"));
			
			switch (rest){
			
			case "cambiarPass":
				String pass = req.getParameter("pass");
				String nuevoPass1 = req.getParameter("nuevoPass1");
				if(!pass.equals(session.getAttribute("pass")))
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/passIncorrecto.jsp");
				else{
					cliente.get(0).setPass(nuevoPass1);
					session = req.getSession(false);
					session.setAttribute("email", null);
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
				}
				break;
				
			case "cambiarMaterno":
				String materno = req.getParameter("materno");
				cliente.get(0).setMaterno(materno);
				session = req.getSession(false);
				session.setAttribute("email", null);
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
				break;
			
			case "cambiarNombre":
				String nombre = req.getParameter("nombre");
				cliente.get(0).setNombre(nombre);
				session = req.getSession(false);
				session.setAttribute("nombre", null);
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
				break;
				
			case "cambiarPaterno":
				String paterno = req.getParameter("paterno");
				cliente.get(0).setPaterno(paterno);
				session = req.getSession(false);
				session.setAttribute("email", null);
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
				break;
				
			default :
			 	mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");	
			break;
			}
			mandar.forward(req, resp);
	}
}
