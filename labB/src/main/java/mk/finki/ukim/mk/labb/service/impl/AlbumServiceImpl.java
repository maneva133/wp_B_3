package mk.finki.ukim.mk.labb.service.impl;

import mk.finki.ukim.mk.labb.model.Album;
import mk.finki.ukim.mk.labb.repository.jpa.AlbumRepositoryJpa;
import mk.finki.ukim.mk.labb.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepositoryJpa albumRepository;
    @Autowired

    public AlbumServiceImpl(AlbumRepositoryJpa albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Album findById(Long id) {
        return albumRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Album> findAllByGenre_Name(String genreName) {
        return albumRepository.findAllByGenre_Name(genreName);
    }

}
