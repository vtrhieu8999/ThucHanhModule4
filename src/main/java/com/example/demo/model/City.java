package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Long area;
    @NotNull
    private Long population;
    @NotNull
    private Long gdp;
    @NotNull
    private String description;

    @ManyToOne
    private Nation nation= new Nation();

}
