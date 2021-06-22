package com.itarocha.stardata.service;

import com.itarocha.stardata.model.*;
import com.itarocha.stardata.model.entities.*;
import com.itarocha.stardata.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MapaService {
	
	@Autowired
	private SignoSolarRepository signoSolarRepository;

	@Autowired
	private MapaCuspideRepository mapaCuspideRepository;

	@Autowired
	private PlanetaSignoRepository planetaSignoRepository;

	@Autowired
	private PlanetaCasaRepository planetaCasaRepository;

	@Autowired
	private MapaPlanetaAspectoRepository mapaPlanetaAspectoRepository;

	public SignoSolarEntity findSignoSolar(String signo) {
		TipoSigno ts = getTipoSigno(signo);
		Optional<SignoSolarEntity> optional = signoSolarRepository.findBySigno(ts);
		return optional.isPresent() ? optional.get() : null;
	}
	
	public MapaCuspideEntity findCuspide(String signo, Integer casa) {
		TipoSigno ts = getTipoSigno(signo);
		Optional<MapaCuspideEntity> optional = mapaCuspideRepository.findCuspide(ts, casa);
		return optional.isPresent() ? optional.get() : null;
	}

	public PlanetaSignoEntity findPlanetaSigno(String planeta, String signo) {
		TipoPlaneta tp = getTipoPlaneta(planeta);
		TipoSigno ts = getTipoSigno(signo);
		Optional<PlanetaSignoEntity> optional = planetaSignoRepository.findPlanetaSigno(tp, ts);
		return optional.isPresent() ? optional.get() : null;
	}
	
	public PlanetaCasaEntity findPlanetaCasa(String planeta, Integer casa) {
		TipoPlaneta tp = getTipoPlaneta(planeta);
		Optional<PlanetaCasaEntity> optional = planetaCasaRepository.findPlanetaCasa(tp, casa);
		return optional.isPresent() ? optional.get() : null;
	}

	public MapaPlanetaAspectoEntity findAspecto(String planetaOrigem, String planetaDestino, String aspecto) {
		TipoPlaneta tpo = getTipoPlaneta(planetaOrigem);
		TipoPlaneta tpd = getTipoPlaneta(planetaDestino);
		TipoAspecto ta = getTipoAspecto(aspecto);
		Optional<MapaPlanetaAspectoEntity> optional = mapaPlanetaAspectoRepository.findAspecto(tpo, tpd, ta);
		return optional.isPresent() ? optional.get() : null;
	}

	private TipoAspecto getTipoAspecto(String aspecto) {
		TipoAspecto ta = null; 
		try {
			ta = TipoAspecto.valueOf(aspecto.toUpperCase());
		} catch(Exception e) {
			ta = TipoAspecto.XX;
		}
		return ta;
	}

	private TipoSigno getTipoSigno(String signo) {
		TipoSigno ts = null; 
		try {
			ts = TipoSigno.valueOf(signo.toUpperCase());
		} catch(Exception e) {
			ts = TipoSigno.XX;
		}
		return ts;
	}

	private TipoPlaneta getTipoPlaneta(String planeta) {
		TipoPlaneta tp = null; 
		try {
			tp = TipoPlaneta.valueOf(planeta.toUpperCase());
		} catch(Exception e) {
			tp = TipoPlaneta.XXX;
		}
		return tp;
	}
}

