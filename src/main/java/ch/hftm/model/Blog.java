package ch.hftm.model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Entity
public class Blog {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Size(min = 2, max = 30, message ="Fehler: Der Titel darf nicht mehr als 30 Zeilen besitzen")
    @NonNull
    private String titel;

    @NotBlank
    @Size(min = 2, max = 250, message ="Fehler: Sie haben mehr als 250 Zeichen oder weniger als 2 Zeichen eingegeben.")
    @NonNull
    private String beschreibung;


    private Boolean likeVonMir;
    private Boolean meineFavoriten;

    @NotBlank
    @NonNull
    private LocalDate blogDatum;


    //Author
    @ManyToOne (cascade = CascadeType.ALL)
    private Author author;

    //Gast
    @ManyToOne (cascade = CascadeType.ALL)
    private Gast gast;

    //Kommentar
    @OneToMany(cascade = CascadeType.ALL)
    private List<Kommentar> kommentar;

    public void addComment(Kommentar kommentar) {
        this.kommentar.add(kommentar);
    }
}
