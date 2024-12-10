//package mk.finki.ukim.mk.labb.web.servlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.labb.model.Artist;
//import mk.finki.ukim.mk.labb.model.Song;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name = "songDetails-servlet", urlPatterns = ("/songDetails"))
//public class songDetails extends HttpServlet {
//
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public songDetails(SpringTemplateEngine springTemplateEngine) {
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange exchange = JakartaServletWebApplication.buildApplication(getServletContext())
//                .buildExchange(req, resp);
//        WebContext context = new WebContext(exchange);
//
//        Song s = (Song) req.getSession().getAttribute("songChosen");
//
//
//        context.setVariable("songS", s);
//
//        springTemplateEngine.process("songDetails.html",context,resp.getWriter());
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    }
//}
