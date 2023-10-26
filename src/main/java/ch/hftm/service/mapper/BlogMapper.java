package ch.hftm.service.mapper;

import ch.hftm.model.Blog;
import ch.hftm.service.dto.BlogDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;

@ApplicationScoped
public class BlogMapper {
    @Valid
    public Blog toValidBlog(BlogDto.NewBlogDto blogDto) {
        return new Blog(blogDto.getTitel(), blogDto.getBeschreibung());
    }
}
