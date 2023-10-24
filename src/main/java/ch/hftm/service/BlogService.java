package ch.hftm.service;

import java.util.List;
import java.util.Optional;

import ch.hftm.model.Kommentar;
import ch.hftm.service.dto.BlogDto;
import ch.hftm.service.dto.CommentDtos;
import ch.hftm.service.mapper.BlogMapper;
import ch.hftm.service.mapper.CommentMapper;
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
    public Optional<Blog> getBlog(long id ) {
        return blogRepository.findByIdOptional(id);
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

    @Transactional
    public long addDtoBlog(BlogDto.NewBlogDto blogDto) {
        Blog blog = new BlogMapper().toValidBlog(blogDto);
        blogRepository.persist(blog);
        return  blog.getId();
    }

    @Transactional
    public long addDtoComment(CommentDtos.NewCommentDto commentDto, int id) {
        Blog blog = getBlog(id).orElseThrow();
        Kommentar kommentar = new CommentMapper().toValidBlogComment(commentDto);
        blog.addComment(kommentar);
        blogRepository.persist(blog);
        return blog.getId();
    }

}
