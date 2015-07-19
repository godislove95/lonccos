package pw;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class SaveUsuario extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher mandar = null ;
		String email=req.getParameter("email");
		String nombre = req.getParameter("nombre");
		String paterno=req.getParameter("paterno");
		String materno = req.getParameter("materno");
		int dni = Integer.parseInt(req.getParameter("dni"));
		String pass =req.getParameter("pass");
		
		Usuario registro = new Usuario(email, nombre, paterno, materno, dni, pass, 0);
		Usuario admin = new Usuario("admin@lonccos.com", "admin", "first", "support", 12312312, "admin", 2);
		registro.getHistorial().add(new Historial("Creo Cuenta", req.getRemoteAddr(), req.getRemoteHost()));
		admin.getHistorial().add(new Historial("Creo Cuenta", req.getRemoteAddr(), req.getRemoteHost()));
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			Query q = pm.newQuery(Usuario.class);
				q.setFilter("email == emailParam");
				q.declareParameters("String emailParam");
				List<Usuario> cliente= (List<Usuario>)q.execute(email);
			if(cliente.size() != 0){
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				return;
			}
			pm.makePersistent(registro);
			pm.makePersistent(admin);
			mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
		}catch(Exception e){
			System.out.println(e);
			mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			
		}finally{
			pm.close();
			mandar.forward(req, resp);
		}
	}
}
