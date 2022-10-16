package org.example.entity;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Класс Page является страницей имеющие сл. параметры ID, путь страницы, код страницы и её контекст.
 */
@Data
@Entity
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "значение должно быть задано")
    private String path;

    @NotNull
    private int code;

    @NotNull
    private String content;

    public Page() {
    }

}
