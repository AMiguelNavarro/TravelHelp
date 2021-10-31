package com.tfg.travelhelp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "vaccine_countries")
public class VaccineCountries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private boolean obligatory;

    @ManyToOne
    @JoinColumn(name = "idVaccine")
    private Vaccine vaccine;

    @ManyToOne
    @JoinColumn(name = "idCountry")
    private Country countryV;
}
