package com.example.jpa;

import com.example.jpa.models.Author;
import com.example.jpa.models.Video;
import com.example.jpa.reposipories.AuthorRepository;
import com.example.jpa.reposipories.VideoRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean {
		return args -> {

			for(int i = 0; i < 50; i++){
				Faker faker  = new Faker();
				var author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(19, 50))
						.email("contact"+i+"@test.com")
						.build();
				authorRepository.save(author);
			}

			var author = Author.builder()
					.id(1)
					.firstName("ahmed")
					.lastName("ali")
					.age(35)
					.email("ahmed_ali@gmail.com")
					.build();
			authorRepository.save(author);

			//authorRepository.updateAuthor(99, 1);

			var authors = authorRepository.findByNamedQuery(30);
			authors.forEach(System.out::println);

			authorRepository.updateByNamedQuery(15, 1);


//			var video = Video.builder()
//					.name("abc")
//					.length(5)
//					.build();
//			videoRepository.save(video);
		};
	}
}
