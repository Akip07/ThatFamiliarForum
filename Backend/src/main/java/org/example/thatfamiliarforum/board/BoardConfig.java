package org.example.thatfamiliarforum.board;

import org.example.thatfamiliarforum.post.Post;
import org.example.thatfamiliarforum.post.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BoardConfig {
    @Bean
    CommandLineRunner commandLineRunnerBoard(BoardRepository repository) {
        return args -> {
            Board b = new Board("b","random","anything that comes to your mind");
            Board tv = new Board("tv","television", "discussing movies, series and other broadcasts");
            repository.saveAll(List.of(b,tv));
        };
    }
}
