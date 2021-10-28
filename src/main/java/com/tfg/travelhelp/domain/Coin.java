package com.tfg.travelhelp.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "coins")
public class Coin {

    // ver info aquí https://www.datosmundial.com/monedas/

    @Schema(description = "Identificador de la moneda", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(description = "código ISO de la moneda", example = "AFN")
    @Column
    private String isoCode;

    @Schema(description = "Símbolo de la moneda", example = "$")
    @Column
    private String symbol;

    @Schema(description = "Divisa de la moneda", example = "Dírham de los EAU")
    @Column
    private String monetaryUnit;
}
