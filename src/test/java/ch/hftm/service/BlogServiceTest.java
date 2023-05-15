package ch.hftm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import jakarta.inject.Inject;
import ch.hftm.model.Blog;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class BlogServiceTest {

    @Inject
    private BlogService blogService;

    private static Blog blog;
    private List<Blog> blogs;



    @BeforeAll
    static void initialiseObjectBlogService() {
        blog = new Blog("Testing Title", "Lorem Ipsum dolor");
    }

    @Test
    void testAddBlog() {
  
        blogService.addBlog(blog);
        blogs = blogService.getBlogs();
        assertEquals(blog.getId(), blogs.get(0).getId());
    
    }

    @Test
    void testGetBlogs() {

        int groesse;

        blogs = blogService.getBlogs();
        groesse = blogs.size();
        blogService.addBlog(new Blog("Titel 1", "Beschreibung 1"));
        assertEquals(groesse + 1, blogService.getBlogs().size());

    }
}