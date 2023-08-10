package ch.hftm.service.dto;

import ch.hftm.model.Kommentar;
import org.hibernate.annotations.Comments;

import java.time.LocalDate;


public interface CommentDtos {

    public record NewCommentDto(String kommentarText, String kommentarAuthor, LocalDate kommentarDatum){
        public Kommentar toComment() {
            return new Kommentar(kommentarText, kommentarAuthor, kommentarDatum);
        }
    }
}
