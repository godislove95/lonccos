package pw;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class SavePlato extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		int precio = Integer.parseInt(req.getParameter("precio"));
		String tipo = req.getParameter("tipo");
		String imagen=req.getParameter("imagen");
		String descripcion = req.getParameter("descripcion");
		
		Plato plato = new Plato(id,nombre, precio, tipo, imagen,descripcion);
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			pm.makePersistent(plato);
			resp.getWriter().println("Datos grabados correctamente");
		}catch(Exception e){
			System.out.println(e);
			resp.getWriter().println("Ocurrió un error, <a href='index.jsp'>vuelva a intentarlo</a>");
		}finally{
			pm.close();
		}
	}
}
