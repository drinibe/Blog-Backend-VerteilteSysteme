package ch.hftm.repository;

import java.util.ArrayList;
import java.util.List;

import ch.hftm.model.Blog;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BlogRepository {

    private static List<Blog> blogs = new ArrayList<>();

    public BlogRepository() {
        blogs.add(new Blog("First Blog", "This is my first blog"));
        blogs.add(new Blog("Second Blog", "This is my second blog"));
    }

    public static List <Blog> getBlogs() {
        return blogs;
    }

    public static void addBlog(Blog blog) {
        blogs.add(blog);
    }
    
}