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

    @PUT
    @Path("/{id}")
    public Response updateBlog(@PathParam("id") long postId, Blog blog) {
        Blog newBlog = this.blogService.updateBlog(postId,blog).orElseThrow(() ->
                new WebApplicationException("Blog wurde nicht gefunden", Response.Status.NOT_FOUND));
        return Response.ok().entity(newBlog).build();
    }

    @DELETE
    @Path("/{id}")
    public Response entfernenBlog(@PathParam("id") Long id) {
        return this.blogService.entfernenBlog(id);
    }




}
