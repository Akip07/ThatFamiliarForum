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
            Post first = new Post("nice day","got a nice day yeah","XXX","/b",1L, 1L );
            Post second = new Post("bad day","kms","XXX1","/tv",2L,2L );
            repository.saveAll(List.of(first,second));
        };
    }
}
