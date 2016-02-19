package fr.isen.steam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

/**
 * Main class, starting Spring runtime and the application.
 *
 * Source's code available at https://github.com/PierreZ/ImageRevolver
 * Travis Build at https://travis-ci.org/PierreZ/ImageRevolver
 */
@SpringBootApplication
public class ImageRevolverApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(ImageRevolverApplication.class, args);
	}
}
