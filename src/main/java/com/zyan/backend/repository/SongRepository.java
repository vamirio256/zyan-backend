package com.zyan.backend.repository;

import com.zyan.backend.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song,Integer> {

    @Query("SELECT s FROM Song s WHERE s.name like %:name%")
    List<Song> findByName(@Param("name") String name);
}
