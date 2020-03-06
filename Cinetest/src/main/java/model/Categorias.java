package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Categorias")
public class Categorias {

	@Id
	@Column(name = "CodCat")
	private Integer codCat;

	@Column(name = "Nombre")
	private String nombre;

	@Column(name = "Descripcion")
	private String descripcion;

	public Categorias() {
		super();
	}

	public Categorias(Integer codCat, String nombre, String descripcion) {
		super();
		this.codCat = codCat;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Integer getCodCat() {
		return codCat;
	}

	public void setCodCat(Integer codCat) {
		this.codCat = codCat;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}