package ch.hftm.model;

import jakarta.persistence.*;
import lombok.*;


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
    

    @ManyToOne (cascade = CascadeType.ALL)
    private Author author;
    

}
