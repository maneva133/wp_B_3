package mk.finki.ukim.mk.labb.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.labb.model.Album;
import mk.finki.ukim.mk.labb.model.Artist;
import mk.finki.ukim.mk.labb.model.Category;
import mk.finki.ukim.mk.labb.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Artist> artists = null;

    public static List<Artist> artistToSong = null;
    public static List<Song> songs = null;

    public static List<Category> categories = null;
    public static List<Album> albums = null;


    @PostConstruct
    public void init() {
//        artists = new ArrayList<>();
//        artists.add(new Artist("Maja", "Maneva", "bio1",new ArrayList<>()));
//        artists.add(new Artist("Eminem", "E", "bio1",new ArrayList<>()));
//        artists.add(new Artist("Abel", "A", "bio1",new ArrayList<>()));
//        artists.add(new Artist("Rihanna", "R", "bio1",new ArrayList<>()));
//        artists.add(new Artist("Amber", "A", "bio1",new ArrayList<>()));


        albums = new ArrayList<>();

        albums.add(new Album("Album1","Rock","2003",new ArrayList<>()));
        albums.add(new Album("Album2","Rock","2003",new ArrayList<>()));
        albums.add(new Album("Album3","Rock","2003",new ArrayList<>()));
        albums.add(new Album("Album4","Rock","2003",new ArrayList<>()));
        albums.add(new Album("Album5","Rock","2003",new ArrayList<>()));
        albums.add(new Album("Album6","Rock","2003",new ArrayList<>()));




        artistToSong = new ArrayList<>();
        songs = new ArrayList<>();
        songs.add(new Song("Title1", "Rock", 2003,new ArrayList<>() ,new Category("Category1"),albums.get(0)));
        songs.add(new Song("Title2", "Pop", 2001, new ArrayList<>(),new Category("Category2"),albums.get(1)));
        songs.add(new Song("Title3", "Rap", 2004, new ArrayList<>(),new Category("Category3"),albums.get(2)));
        songs.add(new Song("Title4", "Rock", 2008, new ArrayList<>(),new Category("Category4"),albums.get(3)));
        songs.add(new Song("Title5", "Pop", 1999, new ArrayList<>(),new Category("Category5"),albums.get(4)));

        categories = new ArrayList<>();
        categories.add(new Category("category1"));
        categories.add(new Category("category2"));
        categories.add(new Category("category3"));
        categories.add(new Category("category4"));
        categories.add(new Category("category5"));


//        INSERT INTO Album (id, name, genre, release_year) VALUES
//                (1, 'The Dark Side of the Moon', 'Progressive Rock', '1973'),
//                (2, 'Abbey Road', 'Rock', '1969'),
//        (3, 'Thriller', 'Pop', '1982'),
//        (4, 'Rumours', 'Rock', '1977');


    }

}
