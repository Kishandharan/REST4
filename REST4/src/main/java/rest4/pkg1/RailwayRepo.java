package rest4.pkg1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RailwayRepo extends JpaRepository<RailwayEntity, Integer> {
	@Query(value="SELECT * FROM railwaystations where station_code=:code", nativeQuery = true)
	public RailwayEntity findByStationCode(@Param("code") String code);
	
	@Query(value="SELECT * FROM railwaystations where station_name LIKE :alpha'%'", nativeQuery = true)
	public List<RailwayEntity> findByAlpha(@Param("alpha") char alpha);
}
