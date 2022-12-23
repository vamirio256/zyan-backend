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
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String file;
    private String image;
    @Column(name = "week_view")
    private int weekView = 0;
    @Column(name = "total_view")
    private int totalView = 0;
    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;
    @Column(name = "updated_at")
    private java.time.LocalDateTime updatedAt;

    @ManyToMany(mappedBy = "genresHasSongs")
    private Set<Genre> genres = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="album_id", referencedColumnName = "id")
    private Album album;
}
