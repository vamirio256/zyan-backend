package com.zyan.backend.repository;

import com.zyan.backend.entity.Album;
import com.zyan.backend.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Integer> {
    @Query("SELECT a.songs from Album a where a.id = ?1")
    Set<Song> findSongsByAlbumId(int id);
}
