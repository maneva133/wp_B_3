package mk.finki.ukim.mk.labb.web.controller;
import mk.finki.ukim.mk.labb.model.Album;
import mk.finki.ukim.mk.labb.model.Review;
import mk.finki.ukim.mk.labb.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.ui.Model;

import mk.finki.ukim.mk.labb.service.AlbumService;
import mk.finki.ukim.mk.labb.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/songs")
public class SongController {

    public final SongService songService;
    public final AlbumService albumService;
    @Autowired

    public SongController(SongService songService, @Lazy AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping("")
    public String getSongsPage(@RequestParam(required = false) String error, Model model){

        model.addAttribute("songs",this.songService.listSongs());
        return "listSongs";
    }

    @PostMapping("/add")
    public String saveSong(@RequestParam Long trackId,
                           @RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam int releaseYear,
                           @RequestParam Long albumId){
        this.songService.save(trackId,title,genre,releaseYear,albumId);

        return "redirect:/songs";


    }

    @GetMapping("/add-song")
    public String addSongPage(Model model){
        List<Album> albumList = albumService.findAll();
        model.addAttribute("albums",albumList);
        return "add-song";
    }
    @GetMapping("/edit-form/{id}")
    public String editSong(@PathVariable Long id, Model model){

        if(songService.findByTrackId(id).isPresent()){
            Song song = this.songService.findByTrackId(id).orElseThrow(RuntimeException::new);
            List<Album> albumList = this.albumService.findAll();
            model.addAttribute("albums",albumList);
            model.addAttribute("song",song);
            return "add-song";
        }

        return "redirect:/songs";

    }

    @PostMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id){
        this.songService.deleteSong(id);
        return "redirect:/songs";
    }

    @GetMapping("/review/{id}")
    public String review(Model model,@PathVariable Long id){
        model.addAttribute("id",id);
        return "review";
    }

    @PostMapping("/addedReview/{id}")
    public String addedReview(@PathVariable Long id,@RequestParam Long reviewId, @RequestParam String comment){
        songService.addReview(new Review(reviewId,comment),songService.findByTrackId(id).orElseThrow(RuntimeException::new));
        return "redirect:/songs";
    }



}
