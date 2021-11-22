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
@AllArgsConstructor @NoArgsConstructor
@Entity(name = "countries")
public class Country {

    @Schema(description = "Identificador del país", example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(description = "Nombre del país", example = "España")
    @Column
    private String name;

    @Schema(description = "Continente al que pertenece", example = "Europa")
    @Column
    private String continent;

    @Schema(description = "Imagen del país", example = "enlace url")
    @Column
    private String flagImage;

    @Schema(description = "Siglas del País", example = "ESP")
    @Column
    private String acronym;

    @Schema(description = "Número de habitantes de un país", example = "47000000")
    @Column
    private int numberOfHabitants;

    @Schema(description = "Es potable el agua si o no", example = "true")
    @Column
    private boolean drinkingWater;

    @Schema(description = "La sanidad es pública si o no", example = "true")
    @Column
    private boolean publicHealthcare;

    @Schema(description = "Prefijo del país", example = "34")
    @Column
    private String prefix;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idCoin")
    private Coin coin; // FK con la tabla COINS

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "idElectricity")
    private Electricity electricity; // FK con la tabla ELECTRITIES

    @ManyToMany
    @JoinTable(
        name = "countries_plugs",
        joinColumns = @JoinColumn(name = "idCountry"),
        inverseJoinColumns = @JoinColumn(name = "idPlug")
    )
    private List<Plug> listPlugs; // Relación N:N con plugs solucionada


    @JsonBackReference(value = "1")
    @OneToMany(mappedBy = "countryL", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<LanguageCountries> listLanguagesCountries;

    @JsonBackReference(value = "2")
    @OneToMany(mappedBy = "countryV", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<VaccineCountries> listVaccinesCountries;


}
