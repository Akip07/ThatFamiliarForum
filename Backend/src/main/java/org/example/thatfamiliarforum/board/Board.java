package org.example.thatfamiliarforum.board;

import jakarta.persistence.*;

@Entity
@Table
public class Board {
    @Id
    @SequenceGenerator(
            name = "board_sequence",
            sequenceName = "board_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "board_sequence"
    )


    private Long id;
    private String initial;
    private String name;
    private String description;

    public Board() {
    }

    public Board(Long id, String initial, String name, String description) {
        this.id = id;
        this.initial = initial;
        this.name = name;
        this.description = description;
    }

    public Board(String initial, String name, String description) {
        this.initial = initial;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

