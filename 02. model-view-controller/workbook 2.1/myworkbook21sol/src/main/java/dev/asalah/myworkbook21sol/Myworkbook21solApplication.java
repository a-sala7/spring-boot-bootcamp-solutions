package dev.asalah.myworkbook21sol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class Myworkbook21solApplication {

	public static void main(String[] args) {
		SpringApplication.run(Myworkbook21solApplication.class, args);
	}
	@GetMapping("/shows")
	public String getShows(){
		return "shows";
	}
}
