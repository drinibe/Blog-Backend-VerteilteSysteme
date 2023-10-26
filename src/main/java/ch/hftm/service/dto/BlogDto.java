package ch.hftm.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

public interface BlogDto {

    @Getter
    @Setter
    @NoArgsConstructor
    public class NewBlogDto {
        private String titel;
        private String beschreibung;
    }

}
