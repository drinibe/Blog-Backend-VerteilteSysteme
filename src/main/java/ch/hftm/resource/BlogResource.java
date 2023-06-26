package ch.hftm.resource;

import ch.hftm.model.Blog;
import ch.hftm.service.BlogService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/blog")
@ApplicationScoped
public class BlogResource {

    @Inject
    BlogService blogService;

    //GET Ruft Informationen ab
    @GET
    public List<Blog> blogs() {
        return this.blogService.getBlogs();
    }

    //POST erstellt Objekte
    @POST
    public void addBlog(Blog blog) {
        this.blogService.addBlog(blog);
    }


}
