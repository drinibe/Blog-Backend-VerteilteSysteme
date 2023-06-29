package ch.hftm.repository;


import jakarta.enterprise.context.ApplicationScoped;
import ch.hftm.model.Blog;
import io.quarkus.hibernate.orm.panache.PanacheRepository;


@ApplicationScoped
public class BlogRepository implements PanacheRepository<Blog>{


    public Blog findBlog(int id) {
        Blog blog = getEntityManager().find(Blog.class, id);
        return blog;
    }

    public void update(Blog blog) {
        getEntityManager().merge(blog);
    }
    
}

