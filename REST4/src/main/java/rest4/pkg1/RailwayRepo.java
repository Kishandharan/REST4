package rest4.pkg1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RailwayRepo extends JpaRepository<RailwayEntity, Integer> {
	@Query(value="SELECT * FROM railwaystations where station_code=:code", nativeQuery = true)
	public RailwayEntity findByStationCode(@Param("code") String code); 
}
