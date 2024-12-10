//package mk.finki.ukim.mk.labb.web.servlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.labb.model.Artist;
//import mk.finki.ukim.mk.labb.model.Category;
//import mk.finki.ukim.mk.labb.model.Song;
//import mk.finki.ukim.mk.labb.service.ArtistService;
//import mk.finki.ukim.mk.labb.service.SongService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.Optional;
//
//@WebServlet(name = "artistServlet", urlPatterns = "/servlet/artist")
//public class АrtistServlet extends HttpServlet {
//
//    private final SpringTemplateEngine springTemplateEngine;
//    private final ArtistService artistService;
//    private final SongService songService;
//
//
//    public АrtistServlet(SpringTemplateEngine springTemplateEngine, ArtistService artistService, SongService songService) {
//        this.springTemplateEngine = springTemplateEngine;
//        this.artistService = artistService;
//        this.songService = songService;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange exchange= JakartaServletWebApplication.buildApplication(getServletContext())
//                .buildExchange(req, resp);
//        WebContext context = new WebContext(exchange);
//
//        Song  s = (Song) req.getSession().getAttribute("songChosen");
//
//
//
//        context.setVariable("songs",req.getSession().getAttribute("songs"));
//        context.setVariable("artists",artistService.listArtists());
//        context.setVariable("songTitle",s.getTitle());
//        context.setVariable("songId",s.getTrackId());
//        springTemplateEngine.process("artistsList.html",context,resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        Optional<Artist> a = artistService.findById(Long.valueOf(req.getParameter("artist")));
//        Song s = (Song) req.getSession().getAttribute("songChosen");
//
//
//        if (a.isPresent()){
//
//
//            songService.addArtistToSong(a.get(), (Song) req.getSession().getAttribute("songChosen"));
//            req.getSession().setAttribute("artist",a);
//            req.getSession().setAttribute("artistId",a.get().getId());
//
//            artistService.addSongToArtist(a.get(),s);
//
//            resp.sendRedirect("/songDetails");
//        }
//
//
//
//
//    }
//}
