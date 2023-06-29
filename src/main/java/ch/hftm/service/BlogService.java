package ch.hftm.service;

import java.util.List;
import java.util.Optional;

import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import ch.hftm.model.Blog;
import ch.hftm.repository.BlogRepository;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Dependent
public class BlogService {
    @Inject
    BlogRepository blogRepository;

    @Inject
    Logger logger;

    public List<Blog> getBlogs() {
        List<Blog> blogs = blogRepository.listAll();
        logger.info("Returning " + blogs.size() + " blogs");
        return blogs;
    }


    @Transactional
    public void addBlog(Blog blog) {
        blogRepository.persist(blog);
        logger.info("Der Blog mit der ID " + blog.getId() + " und mit den Titel: "+ blog.getTitel() + " wurde erfolgreich hinzugefügt.");
    }

    // Blogs mit der ID suchen und löschen, gibt es die ID nicht wird eine Exception ausgelöst mit 404.
    @Transactional
    public Response entfernenBlog(Long id) {
       Blog blog = blogRepository.findById(id);
       if(blog == null) {
           logger.info("Der Blog mit der ID: " + id + " wurde nicht gefunden");
           return Response.status(404).build();
       }
       blogRepository.delete(blog);
       logger.info("Der Blog mit der ID " + id + " wurde erfolgreich gelöscht!");
        return Response.status(204).build();
    }

    //PUT
    //Blog Datum Fehlt, jedoch zu komplex für mich momentan
    //Nicht vergessen noch machen!!!
    @Transactional
    public Optional<Blog> updateBlog(long id, Blog updatedBlog) {
        Optional<Blog> founded = this.blogRepository.findByIdOptional(id);
        founded.ifPresent(blogAktuallisieren -> {
            blogAktuallisieren.setGast(updatedBlog.getGast());
            blogAktuallisieren.setAuthor(updatedBlog.getAuthor());
            blogAktuallisieren.setTitel(updatedBlog.getTitel());
            blogAktuallisieren.setBeschreibung(updatedBlog.getBeschreibung());
            blogAktuallisieren.setLikeVonMir(updatedBlog.getLikeVonMir());
            blogAktuallisieren.setMeineFavoriten(updatedBlog.getMeineFavoriten());
            this.blogRepository.update(blogAktuallisieren);
        });
        return founded;
    }

}
