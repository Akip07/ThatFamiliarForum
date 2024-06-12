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
            Post first = new Post("nice day","got a nice day yeah","https://ecsmedia.pl/c/niepowstrzymany-b-iext132429663.jpg","b",1L, 1L );
            Post second = new Post("bad day","bad day ","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRvlfx7f2SO523tO1ML509nEAbKyHC_lAULew&s","tv",2L,2L );
            Post third = new Post("you are objectively wrong","you are objectively wrong","https://static.zerochan.net/Amane.Kanata.full.3364761.jpg","b",1L,3L );
            repository.saveAll(List.of(first,second, third));
        };
    }
}
