package ch.hftm.model;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Entity
public class Kommentar {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String kommentarText;
    @NonNull
    private String kommentarAuthor;
    @NonNull
    private LocalDate kommentarDatum;

    private Boolean kommentarLikeVonMir;

    @JsonbTransient
    @OneToMany(cascade = CascadeType.ALL)
    private List<Blog> blog;

}
