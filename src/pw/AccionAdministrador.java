package pw;
import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class AccionAdministrador extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher mandar = null ;
		HttpSession session = req.getSession();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Query q = pm.newQuery(Usuario.class);
			
			String accion=req.getParameter("accion");
			
			switch (accion){
			case "borrarAdmin":
				String email = req.getParameter("email");
				q.setFilter("email == emailParam");
				q.declareParameters("String emailParam");
				try {
					List<Usuario> administradores = (List<Usuario>)q.execute(email);
					pm.deletePersistent(administradores.get(0));
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exitoNormal.jsp");
				} catch (Exception e) {
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				}
				break;
				
			default :
			 	mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/opciones_admin.jsp");	
			break;
			}
			mandar.forward(req, resp);
			pm.close();
	}
}