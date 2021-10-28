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
@Entity(name = "emergencyPhones")
public class EmergencyPhone {

    @Schema(description = "Identificador del Teléfono de emergencias", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(description = "Número de teléfono", example = "112")
    @Column
    private String phoneNumber;

    @Schema(description = "Servicio al que pertenece", example = "Emergencias generales")
    @Column
    private String service;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idCountry")
    private Country country; // FK con la tabla COUNTRIES

}
