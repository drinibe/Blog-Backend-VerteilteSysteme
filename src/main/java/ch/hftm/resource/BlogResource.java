package ch.hftm.resource;

import ch.hftm.model.Blog;
import ch.hftm.service.BlogService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/blog")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
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
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBlog(Blog blog) {
        this.blogService.addBlog(blog);
    }

    @DELETE
    @Path("/{id}")
    public Response entfernenBlog(@PathParam("id") Long id) {
        return this.blogService.entfernenBlog(id);
    }

}
