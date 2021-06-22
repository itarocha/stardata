package com.itarocha.stardata.repository;

import com.itarocha.stardata.model.entities.MapaCuspideEntity;
import com.itarocha.stardata.model.TipoSigno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MapaCuspideRepository extends JpaRepository<MapaCuspideEntity, Long> {
	
	@Query("select o from MapaCuspideEntity o order by o.signo, o.casa")
	List<MapaCuspideEntity> findAll();

	@Query("SELECT c FROM MapaCuspideEntity c where c.signo = :SIGNO AND c.casa = :CASA")
	Optional<MapaCuspideEntity> findCuspide(@Param("SIGNO") TipoSigno signo, @Param("CASA")  Integer casa);

}
