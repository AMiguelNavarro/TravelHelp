package com.tfg.travelhelp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity (name = "languages_countries")
public class LanguageCountries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private boolean official;

    @ManyToOne
    @JoinColumn(name = "idLanguage")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "idCountry")
    private Country country;


}
