package ch.hftm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@Entity
public class Blog {

    @Id
    @GeneratedValue
    private Long id;
    private String titel;
    private String beschreibung;
    
    public Blog(String titel, String beschreibung) {
        this.titel = titel;
        this.beschreibung = beschreibung;
    }

    

    

}
