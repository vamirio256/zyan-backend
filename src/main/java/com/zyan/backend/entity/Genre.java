package com.zyan.backend.entity;

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
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String image;
    private java.time.ZonedDateTime createdAt;
    private java.time.ZonedDateTime updatedAt;

    @ManyToMany
    @JoinTable(
            name="genres_has_songs",
            joinColumns = @JoinColumn(name = "genres_id"),
            inverseJoinColumns = @JoinColumn(name = "songs_id")
    )
    private Set<Song> genresHasSongs = new HashSet<>();
}
