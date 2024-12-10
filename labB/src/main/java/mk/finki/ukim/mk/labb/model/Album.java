package mk.finki.ukim.mk.labb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
public class Album {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String genre;
    private String releaseYear;
    @OneToMany(mappedBy = "album")
    private List<Song> songList;

    public Album(String name, String genre, String releaseYear, List<Song> songList) {
//        this.id = (long) (Math.random()*1000);
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.songList = songList;
    }

    public Album() {

    }
}
