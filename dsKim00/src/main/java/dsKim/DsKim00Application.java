package dsKim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

@SpringBootApplication(exclude = {MultipartAutoConfiguration.class})
public class DsKim00Application {

	public static void main(String[] args) {
		SpringApplication.run(DsKim00Application.class, args);
	}

}
