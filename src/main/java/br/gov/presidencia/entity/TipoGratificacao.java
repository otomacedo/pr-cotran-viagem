package br.gov.presidencia.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoGratificacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTipoGratificacao;
		
	private String tipo;
	
	
	public Integer getIdTipoGratificacao() {
		return idTipoGratificacao;
	}
	public void setIdTipoGratificacao(Integer idTipoGratificacao) {
		this.idTipoGratificacao = idTipoGratificacao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	                          
}
