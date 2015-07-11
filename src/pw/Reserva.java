package pw;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
//import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private int codigo;
	
	@Persistent
	private String hora;
	
	@Persistent
	private String numero;
	
	@Persistent
	private String lugar;
	
	@Persistent
	private String zona;
	
	@Persistent
	private String fecha;
	
	@Persistent
	private String tipo;

	public Reserva(int codigo, String hora, String numero, String lugar,
			String zona, String fecha, String tipo) {
		super();
		this.codigo = codigo;
		this.hora = hora;
		this.numero = numero;
		this.lugar = lugar;
		this.zona = zona;
		this.fecha = fecha;
		this.tipo = tipo;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Reserva [codigo=" + codigo + ", hora=" + hora + ", numero="
				+ numero + ", lugar=" + lugar + ", zona=" + zona + ", fecha="
				+ fecha + ", tipo=" + tipo + "]";
	}
	
}