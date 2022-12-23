package com.zyan.backend.controller;

import com.zyan.backend.entity.Song;
import com.zyan.backend.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {


    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @PostMapping("/add")
    public Song addSong(@RequestPart("song") Song song, @RequestPart("file")MultipartFile file) throws IOException {
        return songService.saveSong(song, file);
    }

    @GetMapping("/all")
    public List<Song> findAllSongs(){
//        throw new ApiRequestException("Cannot get all songs");
        return songService.findSongs();
    }

    @GetMapping("/{id}")
    public Song findSongById(@PathVariable int id){
        return songService.findSongById(id);
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
    public String deleteSong(@PathVariable int id) {
        return songService.deleteSong(id);
    }
}
