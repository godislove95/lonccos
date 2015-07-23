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
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/agregarPlato.jsp");
				break;	
			
			case "listarPlato":
				Query qp2=pm.newQuery(Plato.class);
				List<Plato> listarplato=(List<Plato>)qp2.execute();
				req.setAttribute("lista", listarplato);
				System.out.println("golaasdasdasd");
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/listarMenu.jsp");
				break;
				
			case "editarPlato":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/buscarPlato.jsp");
				break;
			
			case "buscarPlato":
				String id = req.getParameter("id");
				Query qp3 = pm.newQuery(Plato.class);
				qp3.setFilter("id == idParam"); 
				qp3.declareParameters("Long idParam");
				List<Plato> platos = (List<Plato>) qp3.execute(Long.parseLong(id));
				if(platos.size() != 0){
					req.setAttribute("plato", platos.get(0));
					session.setAttribute("idPlato", platos.get(0).getId().getId());
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/editarPlato.jsp");
				} else {
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				}
				break;
				
			case "editarPlatoAccion":
				nombre = req.getParameter("nombre");
				int precio = Integer.parseInt(req.getParameter("precio"));
				String tipo = req.getParameter("tipo");
				String descripcion = req.getParameter("descripcion");
				Query qp4 = pm.newQuery(Plato.class);
				qp4.setFilter("id == idParam"); 
				qp4.declareParameters("Long idParam");
				List<Plato> cambioPlatos = (List<Plato>) qp4.execute(Long.parseLong("" + session.getAttribute("idPlato")));
				if(cambioPlatos.size() != 0){
					cambioPlatos.get(0).setNombre(nombre);
					cambioPlatos.get(0).setPrecio(precio);
					cambioPlatos.get(0).setTipo(tipo);
					cambioPlatos.get(0).setDescripcion(descripcion);
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
				} else {
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				}
				break;
				
			case "imagenPlato":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/anadirImagenPlato.jsp");
				System.out.println("dasdasdsad");
				break;
				
			case "agregarBebida":
				Query q5=pm.newQuery(Bebida.class);
				List<Bebida> agregarbebida=(List<Bebida>)q5.execute();
				req.setAttribute("lista", agregarbebida);
				System.out.println("hgf");
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/agregarBebida.jsp");
				break;	
				
			case "listarBebida":
				Query qb2=pm.newQuery(Bebida.class);
				@SuppressWarnings("unchecked")
				List<Bebida> listarbebida=(List<Bebida>)qb2.execute();
				req.setAttribute("lista", listarbebida);
				System.out.println("hghfghfghfhgf");
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/listarBebida.jsp");
				break;	
				
			case "imagenBebida":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/anadirImagenBebida.jsp");
				break;	
				
			case "listarReserva":
				Query qr3=pm.newQuery(Reserva.class);
				@SuppressWarnings("unchecked")
				List<Reserva> reservas=(List<Reserva>)qr3.execute();
				req.setAttribute("lista", reservas);
				System.out.println("jhjhjh");
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/listarReservas.jsp");
				break;	
				
			default :
			 	mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");	
			break;
			}
			mandar.forward(req, resp);
	}
}
