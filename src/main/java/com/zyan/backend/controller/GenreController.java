package com.zyan.backend.controller;

import com.zyan.backend.entity.Genre;
import com.zyan.backend.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/{id}")
    public Genre findGenre(@PathVariable int id){
        return genreService.findGenreById(id);
    }

    @PostMapping("/add")
    public Genre addGenre(@RequestBody Genre genre){
        return genreService.saveGenre(genre);
    }

//    @PutMapping("/{genreId}/song/{songId}")
//    public Genre
}
