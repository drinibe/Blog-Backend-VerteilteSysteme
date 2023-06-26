package ch.hftm.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue
    private long id;
    @NonNull
    private LocalDate geburtstag;
    @NonNull
    private String vorname;
    @NonNull
    private String nachname;
    @NonNull
    private String benutzername;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Blog> blog;

}
