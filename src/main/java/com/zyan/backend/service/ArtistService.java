package com.zyan.backend.service;

import com.zyan.backend.entity.Artist;
import com.zyan.backend.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public Artist saveArtist(Artist artist) {
        artist.setCreatedAt(ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh")));
        artist.setUpdatedAt(ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh")));
        System.out.println(artist.toString());
        return artistRepository.save(artist);
    }

    public List<Artist> getArtists(){
        return artistRepository.findAll();
    }

    public Artist findArtistById(int id) {
        return artistRepository.findById(id).orElse(null);
    }

    public String deleteArtist(int id) {
        artistRepository.deleteById(id);
        return "Artist has been removed " + id;
    }
}
