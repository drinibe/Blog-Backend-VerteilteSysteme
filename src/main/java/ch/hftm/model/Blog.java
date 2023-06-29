package ch.hftm.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Setter
@Getter
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Entity
public class Blog {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String titel;
    @NonNull
    private String beschreibung;


    private Boolean likeVonMir;
    private Boolean meineFavoriten;

    @NonNull
    private LocalDate blogDatum;


    //Author
    @ManyToOne (cascade = CascadeType.ALL)
    private Author author;

    //Gast
    @ManyToOne (cascade = CascadeType.ALL)
    private Gast gast;

    //Kommentar
    @ManyToOne (cascade = CascadeType.ALL)
    private Kommentar kommentar;
    

}
