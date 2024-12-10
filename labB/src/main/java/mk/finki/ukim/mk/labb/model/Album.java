package mk.finki.ukim.mk.labb.model;

import jakarta.persistence.*;
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
//    private String genre;
    @ManyToOne
    private Genre genre;
    private String releaseYear;
    @OneToMany(mappedBy = "album")
    private List<Song> songList;

    public Album(String name, Genre genre, String releaseYear, List<Song> songList) {
//        this.id = (long) (Math.random()*1000);
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.songList = songList;
    }

    public Album() {

    }
}
