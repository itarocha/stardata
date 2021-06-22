package com.itarocha.stardata.repository;

import com.itarocha.stardata.model.entities.PlanetaSignoEntity;
import com.itarocha.stardata.model.TipoPlaneta;
import com.itarocha.stardata.model.TipoSigno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlanetaSignoRepository extends JpaRepository<PlanetaSignoEntity, Long> {

	@Query("select o from PlanetaSignoEntity o order by o.planeta, o.signo")
	List<PlanetaSignoEntity> findAll();

	@Query("SELECT p FROM PlanetaSignoEntity p where p.planeta = :PLANETA AND p.signo = :SIGNO")
	Optional<PlanetaSignoEntity> findPlanetaSigno(@Param("PLANETA") TipoPlaneta tp, @Param("SIGNO") TipoSigno ts);

}
