package rest4.pkg1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Scanner;
import java.io.File;


@RestController
public class RailwayController {
	@Autowired
	RailwayRepo rr;
	
	@PostMapping("/stations/loadFile/{fname}")
	public String load(@PathVariable String fname)throws Exception {
		File f1 = new File(fname);
		Scanner sc1 = new Scanner(f1);
		while(sc1.hasNextLine()) {
			String[] arr1 = sc1.nextLine().split(",");
			String name = arr1[0];
			String code = arr1[1];
			String address = arr1[4];
			rr.save(new RailwayEntity(name, code, address));		
		}
		
		sc1.close();
		return "Success";
	}
}
