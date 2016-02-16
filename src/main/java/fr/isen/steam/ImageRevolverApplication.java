package fr.isen.steam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/**
 * Main class, starting Spring runtime and the application.
 */
@SpringBootApplication
public class ImageRevolverApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(ImageRevolverApplication.class, args);
	}
}
