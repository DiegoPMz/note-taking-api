package io.github.diegopmz.note_taking_api;

import io.github.diegopmz.note_taking_api.entities.NoteEntity;
import io.github.diegopmz.note_taking_api.entities.UserEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class NoteTakingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteTakingApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			System.out.println("---------commandLineRunner---------");
		};
	}

}
