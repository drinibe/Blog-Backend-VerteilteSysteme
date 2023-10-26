package ch.hftm.model;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank
    @Size(min = 2, max = 100, message ="Fehler: Dein Vorname darf nicht länger als 100 Zeichen haben.")
    @NonNull
    private String vorname;

    @NotBlank
    @Size(min = 2, max = 100, message ="Fehler: Dein Nachname darf nicht länger als 100 Zeichen haben.")
    @NonNull
    private String nachname;

    @NotBlank
    @Size(min = 2, max = 100, message ="Fehler: Dein Benutzername darf nicht länger als 100 Zeichen haben.")
    @NonNull
    private String benutzername;

   // @NotBlank
    //@NonNull
    //@JsonbDateFormat("dd.MM.yyyy")
    //private LocalDate geburtstag;

    @NotBlank
    @Email
    @NonNull
    private String eMail;

    @NotBlank
    @NonNull
    private String passwort;


    @JsonbTransient
    @OneToMany(cascade = CascadeType.ALL)
    private List<Blog> blog;

}
