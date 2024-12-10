package mk.finki.ukim.mk.labb.service;

import mk.finki.ukim.mk.labb.model.Artist;
import mk.finki.ukim.mk.labb.model.Review;
import mk.finki.ukim.mk.labb.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> listByCategory(String name);
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    public Optional<Song> findByTrackId(Long trackId);
    Optional<Song> save(Long trackId,String title,String genre,
                        int releaseYear, Long albumId);
    void deleteSong(Long id);

    void addReview(Review r,Song s);
}