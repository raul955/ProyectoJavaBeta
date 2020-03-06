package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Productos {

	@Id
	@Column(name="Codprod")
	private Integer codProd;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Descripcion")
	private String descripcion;
	
	@Column(name="Peso")
	private double peso;
	
	@Column(name="Stock")
	private Integer stock;
	
	@JoinColumn(name="Categoria")
	private Integer categoria;
	
	public Productos() {
		super();
	}
	
	

	public Productos(String nombre) {
		super();
		this.nombre = nombre;
	}



	public Productos(Integer codProd, String nombre, String descripcion, double peso, Integer stock, Integer categoria) {
		super();
		this.codProd = codProd;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.peso = peso;
		this.stock = stock;
		this.categoria = categoria;
	}

	public Integer getCodProd() {
		return codProd;
	}

	public void setCodProd(Integer codProd) {
		this.codProd = codProd;
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

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}
	
}