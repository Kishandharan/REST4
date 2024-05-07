package rest4.pkg1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Scanner;
import java.io.File;


@RestController
public class RailwayController {
	@Autowired
	RailwayRepo rr;
	
	@PostMapping("/stations/loadFile/{fname}")
	public String render_Database(@PathVariable String fname)throws Exception {
		File f1 = new File(fname);
		Scanner sc1 = new Scanner(f1);
		for(int i = 0; i<1000; i++) {
			String[] arr1 = sc1.nextLine().split(",");
			String name = arr1[0];
			String code = arr1[1];
			String address = arr1[4];
			rr.save(new RailwayEntity(name, code, address));		
		}
		
		sc1.close();
		return "Success";
	}
		
	@GetMapping("/stations/renderTabl")
	public List<RailwayEntity> renderTabl(){
		return rr.findAll();
	}
	
	@GetMapping("/stations/findbycode/{code}")
	public RailwayEntity findByCode(@PathVariable String code) {
		return rr.findByStationCode(code);
	}
	
	@GetMapping("/stations/findbyalpha/{alpha}")
	public List<RailwayEntity> findbyalpha(@PathVariable char alpha){
		return rr.findByAlpha(alpha);		
	}
}
