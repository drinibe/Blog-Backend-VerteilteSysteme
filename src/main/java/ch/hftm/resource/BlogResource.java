package ch.hftm.resource;

import ch.hftm.model.Blog;
import ch.hftm.service.BlogService;
import ch.hftm.service.dto.BlogDto;
import ch.hftm.service.dto.CommentDtos;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
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
    @RolesAllowed({"admin", "author"})
    public Response addBlog(@Valid BlogDto.NewBlogDto blogDto) {
        this.blogService.addDtoBlog(blogDto);
        return Response.status(201).build();
    }

    @PUT
    @Path("/{id}")
    @RolesAllowed({"admin", "author"})
    public Response updateBlog(@PathParam("id") long postId, Blog blog) {
        Blog newBlog = this.blogService.updateBlog(postId,blog).orElseThrow(() ->
                new WebApplicationException("Blog wurde nicht gefunden", Response.Status.NOT_FOUND));
        return Response.ok().entity(newBlog).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed({"admin", "author"})
    public Response entfernenBlog(@PathParam("id") Long id) {
        return this.blogService.entfernenBlog(id);
    }

    @POST
    @Path("/{id}/comments")
    @RolesAllowed({"admin","benutzer"})
    public Response addComment(int id, @Valid CommentDtos.NewCommentDto commentDto) {
        this.blogService.addDtoComment(commentDto, id);
        return Response.status(201).build();
    }


}
