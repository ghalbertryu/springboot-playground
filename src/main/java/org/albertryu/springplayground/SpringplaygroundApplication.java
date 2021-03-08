package org.albertryu.springplayground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringplaygroundApplication {

	public SpringplaygroundApplication() {
		System.setProperty("prob1", "abc");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringplaygroundApplication.class, args);
	}

}
