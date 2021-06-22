package com.itarocha.stardata.repository;

import com.itarocha.stardata.model.entities.MapaPlanetaAspectoEntity;
import com.itarocha.stardata.model.TipoAspecto;
import com.itarocha.stardata.model.TipoPlaneta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MapaPlanetaAspectoRepository extends JpaRepository<MapaPlanetaAspectoEntity, Long> {
	
	@Query("select o from MapaPlanetaAspectoEntity o order by o.planetaOrigem, o.aspecto, o.planetaDestino")
	List<MapaPlanetaAspectoEntity> findAll();

	@Query("select o from MapaPlanetaAspectoEntity o WHERE o.tipoRelacao = 'MESTRE' order by o.planetaOrigem, o.aspecto, o.planetaDestino")
	List<MapaPlanetaAspectoEntity> findAllMaster();

	@Query("SELECT a FROM MapaPlanetaAspectoEntity a "
			+ "WHERE ((a.planetaOrigem = :PO AND a.planetaDestino = :PD) "
			+ "OR (a.planetaOrigem = :PD AND a.planetaDestino = :PO)) "
			+ "AND a.aspecto = :ASP")
	Optional<MapaPlanetaAspectoEntity> findAspecto(@Param("PO") TipoPlaneta tpo, @Param("PD") TipoPlaneta tpd, @Param("ASP") TipoAspecto ta);
}
