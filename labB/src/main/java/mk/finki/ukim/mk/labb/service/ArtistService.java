package mk.finki.ukim.mk.labb.service;

import mk.finki.ukim.mk.labb.model.Artist;
import mk.finki.ukim.mk.labb.model.Song;

import java.util.List;
import java.util.Optional;

public interface ArtistService {
    List<Artist> listArtists();
    Optional<Artist> findById(Long id);
//    Song addSongToArtist(Artist artist, Song song);

}
