package org.example.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Index {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "page_id ")
    @NotNull
    private int pageId;

    @Column(name = "lemma_id")
    @NotNull
    private int lemmaId;

    @NotNull
    private float rank;
}
