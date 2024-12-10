package mk.finki.ukim.mk.labb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data

public class Song {
    @Id
    @GeneratedValue
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long trackId;
    private String title;
    private String genre;
    private int releaseYear;

   @ManyToMany
    private List<Artist> performers;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Album album;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "trackId")
    private List<Review> reviews = new ArrayList<>();

    public Song(String title, String genre, int releaseYear, List<Artist> performers,Category category,Album album) {
//        this.trackId = (long) (Math.random()*1000);
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
        this.category = category;
        this.album=album;
        this.reviews = new ArrayList<>();
    }

    public Song() {

    }
}
