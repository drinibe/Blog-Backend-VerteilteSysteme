package ch.hftm.model;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbTransient;
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
    private String vorname;

    @NonNull
    private String nachname;

    @NonNull
    private String benutzername;

    @NonNull
    @JsonbDateFormat("dd.MM.yyyy")
    private LocalDate geburtstag;

    @NonNull
    private String eMail;

    @NonNull
    private String passwort;


    @JsonbTransient
    @OneToMany(cascade = CascadeType.ALL)
    private List<Blog> blog;

}
