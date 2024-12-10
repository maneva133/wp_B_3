package mk.finki.ukim.mk.labb.repository.jpa;

import mk.finki.ukim.mk.labb.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {
    @Override
    List<Genre> findAll();

    @Override
    Optional<Genre> findById(Long aLong);
}
