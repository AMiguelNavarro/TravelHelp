package com.tfg.travelhelp.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
}
