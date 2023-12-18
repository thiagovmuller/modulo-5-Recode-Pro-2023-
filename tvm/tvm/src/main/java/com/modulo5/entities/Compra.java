package com.modulo5.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCompra;

	@Column(nullable = false)
	private Long formaPgto;

	@Column(nullable = false)
	private double valorTotal;

	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "idPassagem")
	private Passagem passagem;

	public Long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}

	public Long getFormaPgto() {
		return formaPgto;
	}

	public void setFormaPgto(Long formaPgto) {
		this.formaPgto = formaPgto;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Passagem getPassagem() {
		return passagem;
	}

	public void setPassagem(Passagem passagem) {
		this.passagem = passagem;
	}

	public Compra(Long idCompra, Long formaPgto, double valorTotal, Cliente cliente, Passagem passagem) {
		super();
		this.idCompra = idCompra;
		this.formaPgto = formaPgto;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
		this.passagem = passagem;
	}

	public Compra() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, formaPgto, idCompra, passagem, valorTotal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(formaPgto, other.formaPgto)
				&& Objects.equals(idCompra, other.idCompra) && Objects.equals(passagem, other.passagem)
				&& Double.doubleToLongBits(valorTotal) == Double.doubleToLongBits(other.valorTotal);
	}
	

}