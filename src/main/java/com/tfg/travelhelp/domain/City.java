package com.tfg.travelhelp.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cities")
public class City {

    @Schema(description = "Identificador de la ciudad", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(description = "Nombre de la ciudad", example = "Zaragoza")
    @Column
    private String name;

    @Schema(description = "Extensión de la ciudad", example = "973.8")
    @Column
    private float extension;

    @Schema(description = "Número de habitantes de la ciudad", example = "666880")
    @Column
    private int numberOfHabitants;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idCountry")
    private Country country; // FK con la tabla COUNTRIES

}
