package com.itarocha.stardata.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itarocha.stardata.model.TipoLogico;
import com.itarocha.stardata.model.TipoSigno;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity()
@Table(name = "mapa_cuspide")
public class MapaCuspideEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	//@NotEmpty(message="Signo é obrigatório")
	@Enumerated(EnumType.STRING)
	private TipoSigno signo;

	//@NotEmpty(message="Casa é obrigatório")
	private Integer casa;
	
	@Lob 
	@Basic(fetch=FetchType.LAZY)
	private String texto;

	@NotNull(message="Conferido é obrigatório")
	@Enumerated(EnumType.STRING)
	private TipoLogico conferido;

	@Transient
	@JsonIgnore
	private boolean foiCoferido;
	
	public Long getId() {
		return id;
	} 

	public void setId(Long id) {
		this.id = id;
	}

	public TipoSigno getSigno() {
		return signo;
	}

	public void setSigno(TipoSigno signo) {
		this.signo = signo;
	}

	public Integer getCasa() {
		return casa;
	}

	public void setCasa(Integer casa) {
		this.casa = casa;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public TipoLogico getConferido() {
		return conferido;
	}

	public void setConferido(TipoLogico conferido) {
		this.conferido = conferido;
	}

	@JsonIgnore
	public boolean getFoiConferido() {
		return this.conferido.equals(TipoLogico.S);
	}
	
}
