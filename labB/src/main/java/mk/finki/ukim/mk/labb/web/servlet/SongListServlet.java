//package mk.finki.ukim.mk.labb.web.servlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.labb.model.Song;
//import mk.finki.ukim.mk.labb.service.SongService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name = "listSongs-servlet",urlPatterns = "/listSongs")
//public class SongListServlet extends HttpServlet {
//
//    public final SongService songService;
//    public final SpringTemplateEngine springTemplateEngine;
//
//
//    public SongListServlet(SongService songService, SpringTemplateEngine springTemplateEngine) {
//        this.songService = songService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange exchange= JakartaServletWebApplication.buildApplication(getServletContext())
//                .buildExchange(req,resp);
//        WebContext context=new WebContext(exchange);
//
//        context.setVariable("categories",songService.listByCategory(req.getParameter("category")));
//            context.setVariable("songs",songService.listSongs());
//            req.getSession().setAttribute("songs",songService.listSongs());
//            springTemplateEngine.process("listSongs.html",context,resp.getWriter());
//
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        String id = req.getParameter("songC");
//        System.out.println(id);
//
//        Song s = songService.findByTrackId(id);
//
//        req.getSession().setAttribute("songChosen", s);
//        resp.sendRedirect("/artist");
//
//    }
//}
