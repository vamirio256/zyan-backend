package com.zyan.backend.service;

import com.zyan.backend.entity.Song;
import com.zyan.backend.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    public Song saveSong(Song song) {
        song.setCreatedAt(LocalDateTime.now());
        song.setUpdatedAt(LocalDateTime.now());
        System.out.println(song.toString());
        return songRepository.save(song);
    }

    public List<Song> saveSongs(List<Song> songs) {
        return songRepository.saveAll(songs);
    }

    public List<Song> getSongs() {
        return songRepository.findAll();
    }

    public Song getSongById(int id) {
        return songRepository.findById(id).orElse(null);
    }

    public List<Song> getSongByName(String name) {
        return songRepository.findByName(name);
    }

    public String deleteSong(int id) {
        songRepository.deleteById(id);
        return "Song has been removed " + id;
    }

    public Song updateSong(Song song) {
        Song existingSong = songRepository.findById(song.getId()).orElse(null);
        existingSong.setName(song.getName());
        existingSong.setFile(song.getFile());
        existingSong.setImage(song.getImage());
        return songRepository.save(existingSong);
    }
}
