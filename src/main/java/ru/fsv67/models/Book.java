package ru.fsv67.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Schema(description = "Сущность книги")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "Идентификатор книги")
    private Long id;

    @Column(name = "name")
    @Schema(description = "Поле название книги")
    private String name;

    public Book(String name) {
        this.name = name;
    }
}
