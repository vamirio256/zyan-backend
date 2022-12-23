package com.zyan.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String file;
    private String image;
    private int weekView = 0;
    private int totalView = 0;
    private java.time.ZonedDateTime createdAt;
    private java.time.ZonedDateTime updatedAt;

    @JsonIgnore
    @ManyToMany(mappedBy = "genresHasSongs")
    private Set<Genre> genres;

    @JsonIgnore
    @ManyToOne
    private Album album;
}
