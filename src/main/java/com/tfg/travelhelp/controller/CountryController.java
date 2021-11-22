package com.tfg.travelhelp.controller;

import com.tfg.travelhelp.domain.City;
import com.tfg.travelhelp.domain.Country;
import com.tfg.travelhelp.dto.CountryDTO;
import com.tfg.travelhelp.service.country.ICountryService;
import com.tfg.travelhelp.utils.ControllersMethodsDTO;
import com.tfg.travelhelp.utils.Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Countries", description = "Listado de paises")
public class CountryController implements ControllersMethodsDTO<Country, CountryDTO> {

    @Autowired
    private ICountryService countryService;


    @Operation(summary = "Obtiene un listado con todos los paises")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Listado de paises", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Country.class))))
    })
    @GetMapping(value = "/country", produces = "application/json")
    @Override
    public ResponseEntity<List<Country>> getAll() {
        List<Country> countryList = countryService.findAllCountries();
        return new ResponseEntity<>(countryList, HttpStatus.OK);
    }




    @Operation(summary = "Obtiene un país por ID de país")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "País por id", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Country.class))))
    })
    @GetMapping(value = "/country/{idCountry}", produces = "application/json")
    public ResponseEntity<Country> getCountryById(@PathVariable("idCountry") long idCountry) {
        Country country = countryService.findCountryById(idCountry);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }


    @Operation(summary = "Añade un nuevo país")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201" , description = "Se añade correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Country.class)))),
            @ApiResponse(responseCode = "409" , description = "El país ya existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @PostMapping(value = "/country", produces = "application/json")
    @Override
    public ResponseEntity<Country> addNew(@RequestBody CountryDTO newCountryDto) {
        val country = countryService.addNewCountry(newCountryDto);
        return new ResponseEntity<>(country, HttpStatus.CREATED);
    }


    @Operation(summary = "Modifica un país")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201" , description = "Se modifica correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Country.class)))),
            @ApiResponse(responseCode = "404" , description = "El país a modificar no existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @PutMapping(value = "/country/{id}", produces = "application/json")
    @Override
    public ResponseEntity<Country> modify(@PathVariable long id, @RequestBody CountryDTO newCountryDto) {
        val country = countryService.modifyCountry(id, newCountryDto);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }


    @Operation(summary = "Elimina un país")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Se elimina correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class)))),
            @ApiResponse(responseCode = "404" , description = "El país a eliminar no existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @DeleteMapping(value = "/country/{id}", produces = "application/json")
    @Override
    public ResponseEntity<Response> delete(@PathVariable long id) {
        countryService.deleteCountry(id);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }
}
