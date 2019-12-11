package com.evliion.ev.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.evliion.ev.model.ChargePoint;
import com.evliion.ev.model.Station;

@Repository
public interface ChargePointRepository extends JpaRepository<ChargePoint, Long>{

	@Query("SELECT s FROM Station s where s.id = :stationId")
	Optional<Station> getStation(@Param("stationId") Long satationId);

	List<ChargePoint> findByStationId(Long stationId);

}
