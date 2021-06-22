package com.itarocha.stardata.repository;

import com.itarocha.stardata.model.entities.SignoSolarEntity;
import com.itarocha.stardata.model.TipoSigno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SignoSolarRepository extends JpaRepository<SignoSolarEntity, Long> {

    @Query("select o from SignoSolarEntity o order by o.signo")
    List<SignoSolarEntity> findAll();

    @Query("SELECT o FROM SignoSolarEntity o where o.signo = :SIGNO")
    Optional<SignoSolarEntity> findBySigno(@Param("SIGNO") TipoSigno tipoSigno);

}
