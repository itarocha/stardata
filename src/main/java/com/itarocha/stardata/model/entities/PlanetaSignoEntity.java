package com.itarocha.stardata.model.entities;

import com.itarocha.stardata.model.TipoLogico;
import com.itarocha.stardata.model.TipoPlaneta;
import com.itarocha.stardata.model.TipoSigno;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity()
@Table(name = "planeta_signo")
public class PlanetaSignoEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private TipoPlaneta planeta;

	@Enumerated(EnumType.STRING)
	private TipoSigno signo;
	
	@Lob 
	@Basic(fetch=FetchType.LAZY)
	private String texto;

	@NotNull(message="Conferido é obrigatório")
	@Enumerated(EnumType.STRING)
	private TipoLogico conferido;
	
	@Transient
	private boolean foiCoferido;
	
	
	public Long getId() {
		return id;
	} 

	public void setId(Long id) {
		this.id = id;
	}

	public TipoPlaneta getPlaneta() {
		return planeta;
	}

	public void setPlaneta(TipoPlaneta planeta) {
		this.planeta = planeta;
	}

	public TipoSigno getSigno() {
		return signo;
	}

	public void setSigno(TipoSigno signo) {
		this.signo = signo;
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

	public boolean getFoiConferido() {
		return this.conferido.equals(TipoLogico.S);
	}
	
}
