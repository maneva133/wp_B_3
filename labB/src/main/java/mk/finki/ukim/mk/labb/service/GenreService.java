package mk.finki.ukim.mk.labb.service;

import mk.finki.ukim.mk.labb.model.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    List<Genre> findAll();
    Optional<Genre> findById(Long aLong);

}
