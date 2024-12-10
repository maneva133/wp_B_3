package mk.finki.ukim.mk.labb.web.controller;
import mk.finki.ukim.mk.labb.model.Song;
import mk.finki.ukim.mk.labb.service.ArtistService;
import mk.finki.ukim.mk.labb.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/artist")
public class ArtistController {

    public final ArtistService artistService;
    public final SongService songService;




    @Autowired
    public ArtistController(ArtistService artistService, @Lazy SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }

    @GetMapping
    public String getArtists(@RequestParam("songC") Long songId, Model model){
        model.addAttribute("artists",artistService.listArtists());
        Song song = songService.findByTrackId(songId).orElseThrow(RuntimeException::new);


        model.addAttribute("songId",song.getTrackId());
        return "artistsList";
    }


    @PostMapping()
    public String addSongToArtist(@RequestParam Long songId, Long artist){
//        this.artistService.addSongToArtist(artistService.findById(artist).get(),songService.findByTrackId(songId).orElseThrow(RuntimeException::new));
        songService.addArtistToSong(artistService.findById(artist).orElseThrow(),songService.findByTrackId(songId).orElseThrow());
        return "redirect:/songs";
    }

}
