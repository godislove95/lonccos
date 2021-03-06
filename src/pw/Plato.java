package pw;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Plato {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key id;
	@Persistent
	private String nombre;
	@Persistent
	private String tipo;
	@Persistent
	private double precio;
	@Persistent
	private String descripcion;
	@Persistent
	private String img;
	@Persistent
	private boolean bloqueado;
	
	public Plato(String nombre, String tipo, double precio, String descripcion,
			String img) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
		this.descripcion = descripcion;
		this.img = img;
		this.bloqueado = false;
	}

	
	public boolean getBloqueado() {
		return bloqueado;
	}


	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}


	public Key getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Plato [nombre=" + nombre + ", tipo=" + tipo + ", precio="
				+ precio + ", descripcion=" + descripcion + ", img=" + img
				+ "]";
	}

	
}