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
			String id, email, paterno, materno, nombre, descripcion, tipo;
			int precio;
			Query qa;
			List<Usuario> users;
			
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
				materno = req.getParameter("materno");
				cliente.get(0).setMaterno(materno);
				session.setAttribute("materno", materno);
				cliente.get(0).getHistorial().add(new Historial("Cambio Materno", req.getRemoteAddr(), req.getRemoteHost()));
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
				break;
			
			case "cambiarNombre":
				nombre = req.getParameter("nombre");
				cliente.get(0).setNombre(nombre);
				session.setAttribute("nombre", nombre);
				cliente.get(0).getHistorial().add(new Historial("Cambio Nombre", req.getRemoteAddr(), req.getRemoteHost()));
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
				break;
				
			case "cambiarPaterno":
				paterno = req.getParameter("paterno");
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
				
			case "bloquearLugar":
				Query l2 = pm.newQuery(Lugar.class);
				List<Lugar> lugar = (List<Lugar>) l2.execute();
				req.setAttribute("lista", lugar);
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/bloquearLugares.jsp");
				break;
				
			case "bloquearPlato":
				Query p2 = pm.newQuery(Plato.class);
				List<Plato> platos2 = (List<Plato>) p2.execute();
				req.setAttribute("lista", platos2);
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/bloquearPlatos.jsp");
				break;
				
			case "bloquearCliente":
				Query c1 = pm.newQuery(Usuario.class);
				c1.setFilter("admin == adminParam");
				c1.declareParameters("Integer adminParam");
				List<Usuario> clientes = (List<Usuario>) c1.execute(0);
				req.setAttribute("lista", clientes);
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/bloquearCliente.jsp");
				break;
			
			case "borrarCliente":
				Query c2 = pm.newQuery(Usuario.class);
				c2.setFilter("admin == adminParam");
				c2.declareParameters("Integer adminParam");
				List<Usuario> borrados = (List<Usuario>) c2.execute(0);
				req.setAttribute("lista", borrados);
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/eliminarCliente.jsp");
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
				
			case "agregarLugar":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/agregarLugar.jsp");
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
				
			case "editarBebida":
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/buscarBebida.jsp");
				break;
			
			case "buscarPlato":
				id = req.getParameter("id");
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
				
			case "buscarBebida":
				System.out.println("x");
				id = req.getParameter("id");
				Query qb1 = pm.newQuery(Bebida.class);
				qb1.setFilter("id == idParam"); 
				qb1.declareParameters("Long idParam");
				List<Bebida> bebidas = (List<Bebida>) qb1.execute(Long.parseLong(id));
				if(bebidas.size() != 0){
					req.setAttribute("bebida", bebidas.get(0));
					session.setAttribute("idBebida", bebidas.get(0).getId().getId());
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/editarPlato.jsp");
				} else {
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				}
				break;
				
			case "editarBebidaAccion":
				System.out.println("ssss");
				nombre = req.getParameter("nombre");
				precio = Integer.parseInt(req.getParameter("precio"));
				tipo = req.getParameter("tipo");
				descripcion = req.getParameter("descripcion");
				Query qb3 = pm.newQuery(Bebida.class);
				qb3.setFilter("id == idParam");
				qb3.declareParameters("Long idParam");
				List<Bebida> cambioBebidas = (List<Bebida>) qb3.execute(Long.parseLong("" + session.getAttribute("idBebida")));
				if(cambioBebidas.size() != 0){
					cambioBebidas.get(0).setNombre(nombre);
					cambioBebidas.get(0).setPrecio(precio);
					cambioBebidas.get(0).setTipo(tipo);
					cambioBebidas.get(0).setDescripcion(descripcion);
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/exito.jsp");
				} else {
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				}
				break;	
				
			case "editarPlatoAccion":
				nombre = req.getParameter("nombre");
				precio = Integer.parseInt(req.getParameter("precio"));
				tipo = req.getParameter("tipo");
				descripcion = req.getParameter("descripcion");
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
				
			case "buscarAdministrador":
				email = req.getParameter("email");
				qa = pm.newQuery(Usuario.class);
				qa.setFilter("email == idParam"); 
				qa.declareParameters("String idParam");
				users = (List<Usuario>) qa.execute(email);
				if(users.size() != 0){
					req.setAttribute("user", users.get(0));
					session.setAttribute("emailBuscado", email);
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/editarAdministrador.jsp");
				} else {
					mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");
				}
				break;
			
			case "editarAdministradorAccion":
				System.out.println("11111");
				nombre = req.getParameter("nombre");
				paterno = req.getParameter("paterno");
				materno = req.getParameter("materno");
				int dni = Integer.parseInt(req.getParameter("dni"));
				qa = pm.newQuery(Usuario.class);
				System.out.println("11111");
				qa.setFilter("email == idParam");
				qa.declareParameters("String idParam");
				users = (List<Usuario>) qa.execute(session.getAttribute("emailBuscado"));
				if(users.size() != 0){
					users.get(0).setNombre(nombre);
					users.get(0).setPaterno(paterno);
					users.get(0).setMaterno(materno);;
					users.get(0).setDni(dni);
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
			case "borrarPlato":
				Query qp=pm.newQuery(Plato.class);
				List<Plato> platos1 = (List<Plato>) qp.execute();
				req.setAttribute("lista", platos1);
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/borrarPlato.jsp");
			break;
			
			case "borrarBebida":
				Query qb=pm.newQuery(Bebida.class);
				List<Bebida> bebida1 = (List<Bebida>) qb.execute();
				req.setAttribute("lista", bebida1);
				mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/borrarBebida.jsp");
			break;
				
			default :
			 	mandar=getServletContext().getRequestDispatcher("/WEB-INF/jsp/error.jsp");	
			break;
			}
			mandar.forward(req, resp);
	}
}
