package pw;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveAdministrador extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws IOException {
			String gmail= req.getParameter("gmail");
			String nombre = req.getParameter("nombre");
			String apellido = req.getParameter("apellido");
			String contraseña = req.getParameter("contraseña");
		

			Administrador a = new Administrador(gmail,nombre, apellido, contraseña );

		final PersistenceManager pm = PMF.get().getPersistenceManager();

		try{
			pm.makePersistent(a);
			System.out.println("si");
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
