package com.IoTeam.ThirstySeedAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ThirstySeedApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirstySeedApiApplication.class, args);
	}

}
