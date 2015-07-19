package pw;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class SalirSesion extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher mandar = null ;

		HttpSession sesion = req.getSession();
        
        PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Usuario.class);
		q.setFilter("email == emailParam");
		q.declareParameters("String emailParam");
		List<Usuario> cliente = (List<Usuario>)q.execute((String)sesion.getAttribute("email"));
		
		sesion = req.getSession(false);
        sesion.setAttribute("email", null);
		
        if(sesion.getAttribute("email") == null){
        	cliente.get(0).getHistorial().add(new Historial("Cerró Sesion", req.getRemoteAddr(), req.getRemoteHost()));
        	mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
        }
        else{    
        	mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");  
        }  
        mandar.forward(req, resp);
	}
}
