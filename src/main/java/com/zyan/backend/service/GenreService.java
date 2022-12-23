package com.zyan.backend.service;

import com.zyan.backend.entity.Genre;
import com.zyan.backend.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public Genre getGenreById(int id){
        return genreRepository.findById(id).orElse(null);
    }

    public Genre saveGenre(Genre genre){
        System.out.println(genre.toString());
        return genreRepository.save(genre);
    }
}
