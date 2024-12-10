package mk.finki.ukim.mk.labb.repository.jpa;

import mk.finki.ukim.mk.labb.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song,Long> {

    @Override
    List<Song> findAll();

    @Override
    <S extends Song> S save(S entity);

    @Override
    Optional<Song> findById(Long aLong);

    @Override
    void deleteById(Long aLong);

    List<Song> findAllByAlbum_Id(Long albumId);
    List<Song> findByCategory_Name(String categoryName);


}
