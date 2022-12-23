package com.zyan.backend.controller;

import com.zyan.backend.entity.Album;
import com.zyan.backend.entity.Song;
import com.zyan.backend.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping("/add")
    public Album addAlbumById(@RequestBody Album album){
        return albumService.saveAlbum(album);
    }

    @GetMapping("/{id}")
    public Album findAlbumById(@PathVariable("id") int id){
        return albumService.findAlbumById(id);
    }

    @GetMapping("/{id}/songs")
    public Set<Song> findSongsByAlbumId(@PathVariable("id") int id){
        return albumService.findSongsByAlbumId(id);
    }
}
