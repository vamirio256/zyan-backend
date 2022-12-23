package com.zyan.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "playlists")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String image;
    @Column(name = "total_view")
    private int totalView = 0;
    @Column(name = "created_at")
    private java.time.ZonedDateTime createdAt;
    @Column(name = "updated_at")
    private java.time.ZonedDateTime updatedAt;
}
