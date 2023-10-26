package ch.hftm.model;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank
    @Size(min = 2, max = 200, message ="Fehler: Dein Kommentar darf nicht länger als 200 Zeichen haben.")
    @NonNull
    private String kommentarText;
    @NotBlank
    @NonNull
    private String kommentarAuthor;
    @NotBlank
    //@NonNull
    //private LocalDate kommentarDatum;

    private Boolean kommentarLikeVonMir;

    @JsonbTransient
    @OneToMany(cascade = CascadeType.ALL)
    private List<Blog> blog;

}
