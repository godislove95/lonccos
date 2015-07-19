package pw;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class SaveReserva extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher mandar = null ;
		HttpSession session = req.getSession();
		String hora = req.getParameter("hora");
		String numero = req.getParameter("numero");
		String lugar = req.getParameter("lugar");
		String zona = "preferencial";
		String tipo= req.getParameter("tipo");
		String fecha =req.getParameter("fecha");
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Usuario.class);
		q.setFilter("email == emailParam");
		q.declareParameters("String emailParam");
		@SuppressWarnings("unchecked")
		List<Usuario> cliente= (List<Usuario>)q.execute(session.getAttribute("email"));
		try{
			Reserva r = new Reserva(hora, numero, lugar, zona, fecha, tipo);
			cliente.get(0).getReservas().add(r);
			cliente.get(0).getHistorial().add(new Historial ("Reservo", req.getRemoteAddr(), req.getRemoteHost()));
			mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
			System.out.println(cliente.get(0).reservas.size());
			
		}catch(Exception e){
			System.out.println(e);
			mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");
		}finally{
			pm.close();
			mandar.forward(req, resp);
		}
	}
}
