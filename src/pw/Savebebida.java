package pw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;




@SuppressWarnings("serial")
public class Savebebida extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		String tipo = req.getParameter("tipo");
		String precio = req.getParameter("precio");
		String descripcion = req.getParameter("descripcion");
		String imagen = req.getParameter("img");

		Bebida b = new Bebida(id,nombre, tipo,precio ,descripcion, imagen);
		

		final PersistenceManager pm = PMF.get().getPersistenceManager();

		try{
			pm.makePersistent(b);
			System.out.println("si");
		}catch(Exception e){
			System.out.println(e);
		}
	}
}