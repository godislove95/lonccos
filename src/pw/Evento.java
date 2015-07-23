package pw;

import java.util.ArrayList;
import java.util.Date;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.repackaged.com.google.datastore.v1.Key;
@PersistenceCapable
public class Evento {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	
	private Key id;
	
	@Persistent
	private String hora;
	
	@Persistent
	private String lugar;

	@Persistent
	private String fecha;
	
	@Persistent
	private String nombre;
	
	@Persistent
	public ArrayList<Historial> historial = new ArrayList<Historial>();

	public Evento( String hora, String lugar, String fecha, String nombre) {
		super();
		this.hora = hora;
		this.lugar = lugar;
		this.fecha = fecha;
		this.nombre = nombre;
	}

	public Key getId() {
		return id;
	}


	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", hora=" + hora + ", lugar=" + lugar
				+ ", fecha=" + fecha + ", nombre=" + nombre + ", historial="
				+ historial + "]";
	}

	

}