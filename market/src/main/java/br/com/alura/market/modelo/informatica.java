package br.com.alura.market.modelo;

import javax.persistence.Entity;

@Entity
public class informatica extends Produto{
	
	private String marca;
	private Integer modelo;
	
	public informatica(String marca, Integer modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getModelo() {
		return modelo;
	}

	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}
	
	
	
	

}
