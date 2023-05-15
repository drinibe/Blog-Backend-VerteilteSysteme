package ch.hftm.repository;


import jakarta.enterprise.context.ApplicationScoped;
import ch.hftm.model.Blog;
import io.quarkus.hibernate.orm.panache.PanacheRepository;


@ApplicationScoped
public class BlogRepository implements PanacheRepository<Blog>{

    
    
    
}