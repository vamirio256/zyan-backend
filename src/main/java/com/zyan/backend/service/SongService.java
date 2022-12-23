package com.zyan.backend.service;

import com.zyan.backend.data.DataHandler;
import com.zyan.backend.entity.Song;
import com.zyan.backend.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private DataHandler dataHandler;

    public Song saveSong(Song song, MultipartFile file) throws IOException {
        song.setCreatedAt(ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh")));
        song.setUpdatedAt(ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh")));
        song.setFile(dataHandler.storeAudio(file, song.getName()));
        return songRepository.save(song);
    }

    public List<Song> saveSongs(List<Song> songs) {
        return songRepository.saveAll(songs);
    }

    public List<Song> findSongs() {
        return songRepository.findAll();
    }

    public Song findSongById(int id) {
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
