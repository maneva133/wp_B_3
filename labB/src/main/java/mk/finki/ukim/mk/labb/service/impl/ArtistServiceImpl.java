package mk.finki.ukim.mk.labb.service.impl;

import mk.finki.ukim.mk.labb.model.Artist;
import mk.finki.ukim.mk.labb.model.Song;
import mk.finki.ukim.mk.labb.repository.jpa.ArtistRepository;
import mk.finki.ukim.mk.labb.repository.jpa.SongRepository;
import mk.finki.ukim.mk.labb.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {


    public final ArtistRepository artistRepository;
    public final SongRepository songRepository;

    @Autowired

    public ArtistServiceImpl(ArtistRepository artistRepository, SongRepository songRepository) {
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
    }

    @Override
    public List<Artist> listArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Optional<Artist> findById(Long id) {
        return artistRepository.findById(id);
    }

//    @Override
//    public Song addSongToArtist(Artist artist, Song song) {
//
//        Artist a = artistRepository.findById(artist.id).orElseThrow(RuntimeException::new);
//        a.songs.add(song);
//
//        artistRepository.save(a);
//        return song;
//    }
}
