package com.modulo5.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Passagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPassagem;

	@Column(nullable = false)
	private String ciaAerea;
	
	@Column(nullable = false)
	private String origem;
	
	@Column(nullable = false)
	private String destino;

	@Column(nullable = false)
	private float valor;

	public Long getIdPassagem() {
		return idPassagem;
	}

	public void setIdPassagem(Long idPassagem) {
		this.idPassagem = idPassagem;
	}

	public String getCiaAerea() {
		return ciaAerea;
	}

	public void setCiaAerea(String ciaAerea) {
		this.ciaAerea = ciaAerea;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Passagem(Long idPassagem, String ciaAerea, String origem, String destino, float valor) {
		super();
		this.idPassagem = idPassagem;
		this.ciaAerea = ciaAerea;
		this.origem = origem;
		this.destino = destino;
		this.valor = valor;
	}

	public Passagem() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(ciaAerea, destino, idPassagem, origem, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passagem other = (Passagem) obj;
		return Objects.equals(ciaAerea, other.ciaAerea) && Objects.equals(destino, other.destino)
				&& Objects.equals(idPassagem, other.idPassagem) && Objects.equals(origem, other.origem)
				&& Float.floatToIntBits(valor) == Float.floatToIntBits(other.valor);
	}
	
	
	
}

	