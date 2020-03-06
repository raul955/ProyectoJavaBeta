package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="restaurantes")
public class Restaurantes {

	@Id
	@Column(name="codres")
	private Integer codRes;
	
	@Column(name="correo")
	private String correo;
	
	@Column(name="clave")
	private String clave;
	
	@Column(name="pais")
	private String pais;
	
	@Column(name="cp")
	private int cp;
	
	@Column(name="ciudad")
	private String ciudad;
	
	@Column(name="direccion")
	private String direccion;

	public Restaurantes() {
		super();
	}

	
	
	public Restaurantes(String correo, String clave) {
		super();
		this.correo = correo;
		this.clave = clave;
	}



	public Restaurantes(int codRes, String correo, String clave, String pais, Integer cp, String ciudad, String direccion) {
		super();
		this.codRes = codRes;
		this.correo = correo;
		this.clave = clave;
		this.pais = pais;
		this.cp = cp;
		this.ciudad = ciudad;
		this.direccion = direccion;
	}

	public int getCodRes() {
		return codRes;
	}

	public void setCodRes(Integer codRes) {
		this.codRes = codRes;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getCp() {
		return cp;
	}

	public void setCp(Integer cp) {
		this.cp = cp;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
	
}