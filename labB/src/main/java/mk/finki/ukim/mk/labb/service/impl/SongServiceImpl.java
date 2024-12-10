package mk.finki.ukim.mk.labb.service.impl;

import mk.finki.ukim.mk.labb.model.*;
import mk.finki.ukim.mk.labb.repository.jpa.AlbumRepositoryJpa;
import mk.finki.ukim.mk.labb.repository.jpa.SongRepository;
import mk.finki.ukim.mk.labb.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final AlbumRepositoryJpa albumRepository;


    @Autowired
    public SongServiceImpl(SongRepository songRepository, @Lazy AlbumRepositoryJpa albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        Song existingSong = songRepository.findById(song.getTrackId())
                .orElseThrow(() -> new RuntimeException("Song not found"));

        existingSong.getPerformers().add(artist);

        songRepository.deleteById(song.getTrackId());
        songRepository.save(existingSong);

        return artist;
    }
    @Override
    public Optional<Song> findByTrackId(Long trackId) {
        return songRepository.findById(trackId);
    }

    @Override
    public List<Song> listByCategory(String name) {
        return songRepository.findByCategory_Name(name);
    }

    @Override
    public Optional<Song> save(Long trackId, String title, String genre,
                               int releaseYear, Long albumId) {
        Album album = albumRepository.findById(albumId).orElseThrow();

        songRepository.deleteById(trackId);


        Song song = new Song(title, genre, releaseYear, new ArrayList<>(), new Category("Cat1"), album);
        song.setTrackId(trackId);
        Song savedSong = songRepository.save(song);

        return Optional.of(savedSong);  // Return the saved song
    }
    @Override
    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }

    @Override
    public void addReview(Review r, Song s) {
        Song song = songRepository.findById(s.getTrackId()).orElseThrow(() -> new RuntimeException("No such song"));

        song.getReviews().add(r);
        songRepository.save(song);

    }


}
