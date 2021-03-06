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
@Entity(name = "vaccines")
public class Vaccine {

    @Schema(description = "Identificador de la vacuna", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(description = "Efectividad de la vacuna", example = "90.5%")
    @Column
    private double effectivity;

    @Schema(description = "Nombre de la vacuna", example = "Malaria")
    @Column
    private String name;

    @Schema(description = "Durabilidad", example = "90 días")
    @Column
    private int durability;

    @JsonBackReference
    @OneToMany(mappedBy = "vaccine", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<VaccineCountries> listVaccinesCountries;

}
