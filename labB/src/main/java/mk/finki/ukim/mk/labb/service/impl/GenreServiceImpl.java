package mk.finki.ukim.mk.labb.service.impl;

import mk.finki.ukim.mk.labb.model.Genre;
import mk.finki.ukim.mk.labb.repository.jpa.GenreRepository;
import mk.finki.ukim.mk.labb.service.GenreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class GenreServiceImpl implements GenreService {
    public final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> findAll() {

        return genreRepository.findAll();
    }

    @Override
    public Optional<Genre> findById(Long aLong) {
        return genreRepository.findById(aLong);
    }
}
