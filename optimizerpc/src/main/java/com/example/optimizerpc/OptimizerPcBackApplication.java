package com.example.optimizerpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.TimeZone;

@SpringBootApplication
public class OptimizerPcBackApplication {

	public static void main(String[] args) {
		Locale.setDefault(Locale.of("es", "ES"));
		TimeZone.setDefault(TimeZone.getTimeZone("Europe/Madrid"));
		SpringApplication.run(OptimizerPcBackApplication.class, args);
	}

}
