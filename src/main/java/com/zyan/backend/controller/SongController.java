package com.zyan.backend.controller;

import com.zyan.backend.entity.Song;
import com.zyan.backend.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/song")
public class SongController {

    @Autowired
    private SongService songService;

    @PostMapping("/add")
    public Song addSong(@RequestBody Song song){
        return songService.saveSong(song);
    }

    @PostMapping("/adds")
    public List<Song> addSongs(@RequestBody List<Song> songs){
        return songService.saveSongs(songs);
    }

    @GetMapping("/all")
    public List<Song> findAllSongs(){
        return songService.getSongs();
    }

    @GetMapping("/{id}")
    public Song findSongById(@PathVariable int id){
        return songService.getSongById(id);
    }

    @GetMapping()
    public List<Song> findSongByName(@RequestParam(value = "name") String name){
        return songService.getSongByName(name);
    }

    @PutMapping("/update")
    public Song updateSong(@RequestBody Song song){
        return songService.updateSong(song);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSong(int id) {
        return songService.deleteSong(id);
    }
}
