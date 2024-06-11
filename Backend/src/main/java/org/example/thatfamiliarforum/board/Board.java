package org.example.thatfamiliarforum.board;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Board {
    @Id
    @SequenceGenerator(
            name = "table_sequence",
            sequenceName = "table_sequence",
            allocationSize = 1
    )
    private String id;
    private String name;
    private String description;

    public Board() {
    }

    public Board(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }



    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

