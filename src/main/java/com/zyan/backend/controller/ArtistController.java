package com.zyan.backend.controller;

import com.zyan.backend.entity.Artist;
import com.zyan.backend.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping("/{id}")
    public Artist findArtistById(@PathVariable int id){return artistService.findArtistById(id);}

    @PostMapping("/add")
    public Artist saveArtist(@RequestBody Artist artist){return artistService.saveArtist(artist);}

    @DeleteMapping("/delete/{id}")
    public String deleteArtist(@PathVariable int id){return artistService.deleteArtist(id);}
}
