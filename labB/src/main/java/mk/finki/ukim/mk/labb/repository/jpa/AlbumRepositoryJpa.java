package mk.finki.ukim.mk.labb.repository.jpa;

import mk.finki.ukim.mk.labb.model.Album;
import mk.finki.ukim.mk.labb.model.Song;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepositoryJpa extends JpaRepository<Album,Long> {

    @Override
    List<Album> findAll();

    @Override
    List<Album> findAllById(Iterable<Long> longs);
    List<Album> findAllByGenre_Name(String genreName);

}
