package model;

public class ProdCarrito {

	private Integer id;

	private String nombre;

	private String descripcion;

	private double peso;

	private Integer stock;

	private Integer categoria;

	private Integer numComprar;

	public ProdCarrito() {
		super();
	}

	public ProdCarrito(Integer id, String nombre, String descripcion, double peso, Integer stock, Integer categoria,
			Integer numComprar) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.peso = peso;
		this.stock = stock;
		this.categoria = categoria;
		this.setNumComprar(numComprar);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getNumComprar() {
		return numComprar;
	}

	public void setNumComprar(Integer numComprar) {
		this.numComprar = numComprar;
	}
}