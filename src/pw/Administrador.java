package pw;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Administrador {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private String gmail;
	@Persistent
	private String nombre;
	@Persistent
	private String apellido;
	@Persistent
	private String contraseña;
	public Administrador(String gmail, String nombre, String apellido,
			String contraseña) {
		super();
		this.gmail = gmail;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contraseña = contraseña;
	}
	public String getGmail() {
		return gmail;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	@Override
	public String toString() {
		return "Administrador [gmail=" + gmail + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", contraseña=" + contraseña + "]";
	}
	
	
	
	
	

}
