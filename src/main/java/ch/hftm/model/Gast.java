package ch.hftm.model;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Entity
public class Gast {

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
    private String eMail;

    @JsonbTransient
    @OneToMany(cascade = CascadeType.ALL)
    private List<Blog> blog;

}