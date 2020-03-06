package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pedidosproductos")
public class PedidosProductos {

	@Id
	@Column(name = "Codpedprod")
	private Integer codPedProd;

	@Column(name = "pedido")
	private Integer pedido;

	@Column(name = "producto")
	private Integer producto;

	@Column(name = "unidades")
	private Integer unidades;

	public PedidosProductos() {
		super();
	}

	public PedidosProductos(Integer codPedProd, Integer pedido, Integer producto, Integer unidades) {
		super();
		this.codPedProd = codPedProd;
		this.pedido = pedido;
		this.producto = producto;
		this.unidades = unidades;
	}

	public Integer getCodPedProd() {
		return codPedProd;
	}

	public void setCodPedProd(Integer codPedProd) {
		this.codPedProd = codPedProd;
	}

	public Integer getPedido() {
		return pedido;
	}

	public void setPedido(Integer pedido) {
		this.pedido = pedido;
	}

	public Integer getProducto() {
		return producto;
	}

	public void setProducto(Integer producto) {
		this.producto = producto;
	}

	public Integer getUnidades() {
		return unidades;
	}

	public void setUnidades(Integer unidades) {
		this.unidades = unidades;
	}

}