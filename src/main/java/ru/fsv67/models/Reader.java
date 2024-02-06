package ru.fsv67.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Schema(description = "Сущность читатель")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "Идентификатор читателя")
    private Long id;

    @Column(name = "name")
    @Schema(description = "Поле имя читателя")
    private String name;

    public Reader(String name) {
        this.name = name;
    }
}
