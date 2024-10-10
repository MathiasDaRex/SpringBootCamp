package com.mathiasdarex.SpringCoreDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
// We can add beans out the main app package:
// Explicitly list base packages to scan as parameter to the
// main apps @SpringBootApplication anottation

@SpringBootApplication(
		scanBasePackages = {"com.mathiasdarex.SpringCoreDemo",
							"com.mathiasdarex.util"}
)

 */

public class SpringCoreDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCoreDemoApplication.class, args);
	}

}
