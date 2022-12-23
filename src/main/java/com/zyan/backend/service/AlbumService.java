package com.zyan.backend.service;

import com.zyan.backend.entity.Album;
import com.zyan.backend.entity.Song;
import com.zyan.backend.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Album findAlbumById(int id){
        Album album = albumRepository.findById(id).orElse(null);
        assert album != null;
        album.setSongs(albumRepository.findSongsByAlbumId(id));
        return album;
    }

    public Set<Song> findSongsByAlbumId(int id){
        return albumRepository.findSongsByAlbumId(id);
    }

    public Album saveAlbum(Album album){
        album.setCreatedAt(ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh")));
        album.setUpdatedAt(ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh")));
        return albumRepository.save(album);
    }

    public String deleteAlbum(int id){
        albumRepository.deleteById(id);
        return "Song has been removed " + id;
    }
}
