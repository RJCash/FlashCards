package com.RickieProject.FlashCardCreater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.RickieProject.FlashCardCreater")
public class FlashCardCreaterApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlashCardCreaterApplication.class, args);
	}

}
