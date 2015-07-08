package pw;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class xD extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		String email=req.getParameter("email");
		String nombre = req.getParameter("nombre");
		String paterno=req.getParameter("paterno");
		String materno = req.getParameter("materno");
		int dni = Integer.parseInt(req.getParameter("dni"));
		String pass =req.getParameter("pass");
		
		Cliente p = new Cliente(email, nombre, paterno, materno, dni, pass);
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Cliente.class);
		
		try{
			pm.makePersistent(p);
			resp.getWriter().print("<p> Datos grabados correctamente </p1>");
			
			
		}catch(Exception e){
			System.out.println(e);
			resp.getWriter().println("Ocurrió un error, <a href='index.jsp'>vuelva a intentarlo</a>");
			
		}finally{
			pm.close();
		}
	}
}