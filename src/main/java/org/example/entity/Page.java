package org.example.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "search_engine")
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
}
