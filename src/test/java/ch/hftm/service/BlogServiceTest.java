package ch.hftm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import jakarta.inject.Inject;

import ch.hftm.model.Blog;
import ch.hftm.repository.BlogRepository;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class BlogServiceTest {

    @Inject
    private BlogService blogService;

    private static Blog blog;

    private int blogRepoSize;
    private int blogServiceSize;

    @BeforeAll
    static void initialiseObjectBlogService() {
        blog = new Blog("Testing Title", "Lorem Ipsum dolor");
    }

    @Test
    void testGetBlogs() {
        blogRepoSize = BlogRepository.getBlogs().size();
        blogServiceSize = blogService.getBlogs().size();
        assertEquals(blogRepoSize, blogServiceSize);
    }

    @Test
    void testAddBlog() {
        blogService.addBlog(blog);
        assertEquals(blogRepoSize, blogServiceSize);
    }

}