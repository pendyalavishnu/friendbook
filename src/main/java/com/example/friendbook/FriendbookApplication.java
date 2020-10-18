package com.example.friendbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class FriendbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(FriendbookApplication.class, args);
	}

}
