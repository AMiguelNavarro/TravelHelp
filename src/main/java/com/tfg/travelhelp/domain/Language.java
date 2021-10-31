package com.tfg.travelhelp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "languages")
public class Language {

    @Schema(description = "Identificador del lenguaje", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(description = "Nombre del lenguaje", example = "castellano")
    @Column
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "language")
    private List<LanguageCountries> listLanguagesCountries;
}
