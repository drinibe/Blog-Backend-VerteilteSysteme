package ch.hftm.service.mapper;


import ch.hftm.model.Kommentar;
import ch.hftm.service.dto.CommentDtos;

public class CommentMapper {
    public Kommentar toValidBlogComment(CommentDtos.NewCommentDto commentDto) {
        return  new Kommentar(commentDto.kommentarText(), commentDto.kommentarAuthor(), commentDto.kommentarDatum());
    }
}