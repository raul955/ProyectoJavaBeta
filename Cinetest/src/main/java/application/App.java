package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import controller.Controlador;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(Controlador.class, args);
	}

}
