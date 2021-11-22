package com.tfg.travelhelp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "plugs")
public class Plug {

    @Schema(description = "Identificador del enchufe", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(description = "Imagen del enchufe", example = "enlace url")
    @Column
    private String image;

    @Schema(description = "Tipo de enchufe", example = "tipo C")
    @Column
    private char type; // Siempre es un caracter https://www.momondo.es/discover/guia-basica-de-los-enchufes-del-mundo

    @ManyToMany(mappedBy = "listPlugs")
    @JsonBackReference
    private List<Country> listCountries;
}
