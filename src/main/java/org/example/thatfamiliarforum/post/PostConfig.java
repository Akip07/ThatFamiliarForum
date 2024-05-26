package org.example.thatfamiliarforum.post;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JULY;
import static java.time.Month.MAY;

@Configuration
public class PostConfig {
    @Bean
    CommandLineRunner commandLineRunner(PostRepository repository) {
        return args -> {
            Post first = new Post("nice day", "XXX",1L);
            Post second = new Post("nice day", "XXX",1L);
            repository.saveAll(List.of(first,second));
        };
    }
}
