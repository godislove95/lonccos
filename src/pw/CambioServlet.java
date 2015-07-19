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
					session.setAttribute("pass", nuevoPass1);
					cliente.get(0).getHistorial().add(new Historial("Cambio Contraseña", req.getRemoteAddr(), req.getRemoteHost()));
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
				}
				break;
				
			case "cambiarMaterno":
				String materno = req.getParameter("materno");
				cliente.get(0).setMaterno(materno);
				session.setAttribute("materno", materno);
				cliente.get(0).getHistorial().add(new Historial("Cambio Materno", req.getRemoteAddr(), req.getRemoteHost()));
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
				break;
			
			case "cambiarNombre":
				String nombre = req.getParameter("nombre");
				cliente.get(0).setNombre(nombre);
				session.setAttribute("nombre", nombre);
				cliente.get(0).getHistorial().add(new Historial("Cambio Nombre", req.getRemoteAddr(), req.getRemoteHost()));
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
				break;
				
			case "cambiarPaterno":
				String paterno = req.getParameter("paterno");
				cliente.get(0).setPaterno(paterno);
				session.setAttribute("paterno", paterno);
				cliente.get(0).getHistorial().add(new Historial("Cambio Paterno", req.getRemoteAddr(), req.getRemoteHost()));
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
				break;
				
			case "misReservas":
				req.setAttribute("lista", cliente.get(0).getReservas());
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/mostrarReservas.jsp");
				break;
				
			case "eliminarReserva":
				String idReserva = req.getParameter("idReserva");
				String correct;
				for(Reserva p : cliente.get(0).getReservas()){
					correct = "" + p.getKey().getId();
					if(correct.equals(idReserva)){
						cliente.get(0).getReservas().remove(p);
						cliente.get(0).getHistorial().add(new Historial("Elimino Reserva", req.getRemoteAddr(), req.getRemoteHost()));
						mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
						req.setAttribute("lista", cliente.get(0).getReservas());
						mandar.forward(req, resp);
						return;
					}
				}
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/noExisteReserva.jsp");
				break;
				
			case "listarCliente":
				Query q2=pm.newQuery(Usuario.class);
				List<Usuario> listarCliente=(List<Usuario>)q2.execute();
				req.setAttribute("lista", listarCliente);
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/mostrarCliente.jsp");
				break;
			
			case "historialCliente":
				Query q3=pm.newQuery(Usuario.class);
				List<Usuario> historialCliente=(List<Usuario>)q3.execute();
				req.setAttribute("lista", historialCliente);
				System.out.println("hgf");
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/historialClientes.jsp");
				break;	
			
			case "agregarPlato":
				Query q4=pm.newQuery(Usuario.class);
				List<Usuario> agregarplato=(List<Usuario>)q4.execute();
				req.setAttribute("lista", agregarplato);
				System.out.println("hgf");
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/agregarPlato.jsp");
				break;	
			
			case "agregarBebida":
				Query q5=pm.newQuery(Usuario.class);
				List<Usuario> agregarbebida=(List<Usuario>)q5.execute();
				req.setAttribute("lista", agregarbebida);
				System.out.println("hgf");
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/agregarBebida.jsp");
				break;	
				
			case "imagenBebida":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/anadirImagenBebida.jsp");
				break;	
			default :
			 	mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");	
			break;
			}
			mandar.forward(req, resp);
	}
}
