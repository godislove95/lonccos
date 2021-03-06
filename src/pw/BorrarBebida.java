package pw;
import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class BorrarBebida extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher mandar = null ;
		HttpSession session = req.getSession();
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		Query q = pm.newQuery(Bebida.class);
			
			String accion=req.getParameter("accion");
			
			switch (accion){
			case "borrarAccionBebida":
				String id = req.getParameter("id");
				q.setFilter("id == idParam");
				q.declareParameters("Long idParam");
				try {
					List<Bebida> platos = (List<Bebida>) q.execute(Long.parseLong(id));
					System.out.println(id);
					pm.deletePersistent(platos.get(0));
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exitoNormal.jsp");
				} catch (Exception e) {
					System.out.println(e);
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