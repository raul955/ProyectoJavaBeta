package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedidos {

	@Id
	@Column(name = "Codped")
	private Integer codPed;

	@Column(name = "Fecha")
	private Date fecha;

	@Column(name = "enviado")
	private Integer enviado;

	@JoinColumn(name = "Codres")
	private Integer codRes;

	public Pedidos() {
		super();
	}

	public Pedidos(Integer codPed, Date fecha, Integer enviado, Integer codRes) {
		super();
		this.codPed = codPed;
		this.fecha = fecha;
		this.enviado = enviado;
		this.codRes = codRes;
	}

	public Integer getCodPed() {
		return codPed;
	}

	public void setCodPed(Integer codPed) {
		this.codPed = codPed;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fechaPed) {
		this.fecha = fechaPed;
	}

	public Integer getEnviado() {
		return enviado;
	}

	public void setEnviado(Integer enviado) {
		this.enviado = enviado;
	}

	public Integer getCodRes() {
		return codRes;
	}

	public void setCodRes(Integer codRes) {
		this.codRes = codRes;
	}
}