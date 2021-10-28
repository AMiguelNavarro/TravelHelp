package com.tfg.travelhelp.domain;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "electricities")
public class Electricity {

    @Schema(description = "Identificador de la electricidad", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(description = "Voltaje", example = "220")
    @Column
    private int voltage;

    @Schema(description = "Frecuencia", example = "50")
    @Column
    private int frecuency;
}
