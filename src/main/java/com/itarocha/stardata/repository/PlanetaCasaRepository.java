package com.itarocha.stardata.repository;

import com.itarocha.stardata.model.entities.PlanetaCasaEntity;
import com.itarocha.stardata.model.TipoPlaneta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlanetaCasaRepository extends JpaRepository<PlanetaCasaEntity, Long> {

	@Query("select o from PlanetaCasaEntity o order by o.planeta, o.casa")
	List<PlanetaCasaEntity> findAll();

	@Query("SELECT pc FROM PlanetaCasaEntity pc where pc.planeta = :PLANETA AND pc.casa = :CASA")
	Optional<PlanetaCasaEntity> findPlanetaCasa(@Param("PLANETA") TipoPlaneta tp, @Param("CASA") Integer casa);
}
