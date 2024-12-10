package mk.finki.ukim.mk.labb.repository.jpa;

import mk.finki.ukim.mk.labb.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist,Long> {
    @Override
    List<Artist> findAll();

    @Override
    <S extends Artist> S save(S entity);

    @Override
    void deleteById(Long aLong);
}
