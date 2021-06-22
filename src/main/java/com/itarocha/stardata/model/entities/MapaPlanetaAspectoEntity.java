package com.itarocha.stardata.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itarocha.stardata.model.TipoAspecto;
import com.itarocha.stardata.model.TipoLogico;
import com.itarocha.stardata.model.TipoPlaneta;
import com.itarocha.stardata.model.TipoRelacao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity()
@Table(name = "mapa_planeta_aspecto")
public class MapaPlanetaAspectoEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotNull(message="Planeta de Origem é obrigatório")
	@Enumerated(EnumType.STRING)
	private TipoPlaneta planetaOrigem;

	@NotNull(message="Planeta Destino é obrigatório")
	@Enumerated(EnumType.STRING)
	private TipoPlaneta planetaDestino;
	
	@NotNull(message="Tipo de Aspecto é obrigatório")
	@Enumerated(EnumType.STRING)
	private TipoAspecto aspecto;

	@NotNull(message="Tipo de Relação é obrigatório")
	@Enumerated(EnumType.STRING)
	private TipoRelacao tipoRelacao;
	
	@NotNull(message="Conferido é obrigatório")
	@Enumerated(EnumType.STRING)
	private TipoLogico conferido;

	@ManyToOne
	@JoinColumn(name = "id_mestre")
	private MapaPlanetaAspectoEntity aspectoMestre;
	
	@Lob 
	@Basic(fetch=FetchType.LAZY)
	//@NotNull(message="Texto é obrigatório") // não é mais obrigatório
	private String texto;

	@Transient
	private String descricaoResumida;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoPlaneta getPlanetaOrigem() {
		return planetaOrigem;
	}

	public void setPlanetaOrigem(TipoPlaneta planetaOrigem) {
		this.planetaOrigem = planetaOrigem;
	}

	public TipoPlaneta getPlanetaDestino() {
		return planetaDestino;
	}

	public void setPlanetaDestino(TipoPlaneta planetaDestino) {
		this.planetaDestino = planetaDestino;
	}

	public TipoAspecto getAspecto() {
		return aspecto;
	}

	public void setAspecto(TipoAspecto aspecto) {
		this.aspecto = aspecto;
	}

	public TipoRelacao getTipoRelacao() {
		return tipoRelacao;
	}

	public void setTipoRelacao(TipoRelacao tipoRelacao) {
		this.tipoRelacao = tipoRelacao;
	}

	public MapaPlanetaAspectoEntity getAspectoMestre() {
		return aspectoMestre;
	}

	public void setAspectoMestre(MapaPlanetaAspectoEntity aspectoMestre) {
		this.aspectoMestre = aspectoMestre;
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
	@Transient
	public boolean getFoiConferido() {
		return TipoLogico.S.equals(this.conferido);
	}
	
	public String getDescricaoResumida() {
		return String.format("%s %s %s", this.planetaOrigem.getDescricao(), this.getAspecto().getDescricao(), this.planetaDestino.getDescricao()).toUpperCase();
	}
	
}
