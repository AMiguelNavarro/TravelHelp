package com.tfg.travelhelp.controller;

import com.tfg.travelhelp.domain.City;
import com.tfg.travelhelp.domain.Electricity;
import com.tfg.travelhelp.dto.CityDTO;
import com.tfg.travelhelp.service.city.ICityService;
import com.tfg.travelhelp.utils.ControllersMethods;
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
@Tag(name = "Cities", description = "Listado de ciudades")
public class CityController implements ControllersMethodsDTO<City, CityDTO> {

    @Autowired
    private ICityService cityService;


    @Operation(summary = "Obtiene un listado con todas las ciudades")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Listado de ciudades", content = @Content(array = @ArraySchema(schema = @Schema(implementation = City.class))))
    })
    @GetMapping(value = "/city", produces = "application/json")
    @Override
    public ResponseEntity<List<City>> getAll() {
        List<City> cityList = cityService.finAllCities();
        return new ResponseEntity<>(cityList, HttpStatus.OK);
    }


    @Operation(summary = "Añade una nueva ciudad")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201" , description = "Se añade correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = City.class)))),
            @ApiResponse(responseCode = "409" , description = "La ciudad ya existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @PostMapping(value = "/city", produces = "application/json")
    @Override
    public ResponseEntity<City> addNew(@RequestBody CityDTO newCityDto) {
        val newCity = cityService.addNewCity(newCityDto);
        return new ResponseEntity<>(newCity, HttpStatus.CREATED);
    }


    @Operation(summary = "Modifica una ciudad")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201" , description = "Se modifica correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = City.class)))),
            @ApiResponse(responseCode = "404" , description = "La ciudad a modificar no existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @PutMapping(value = "/city/{idOldCity}", produces = "application/json")
    @Override
    public ResponseEntity<City> modify(@PathVariable long idOldCity, @RequestBody CityDTO newCityDto) {
        val newCity = cityService.modifyCity(idOldCity, newCityDto);
        return new ResponseEntity<>(newCity, HttpStatus.OK);
    }


    @Operation(summary = "Elimina una ciudad")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Se elimina correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class)))),
            @ApiResponse(responseCode = "404" , description = "La ciudad a eliminar no existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @DeleteMapping(value = "/city/{idOldCity}", produces = "application/json")
    @Override
    public ResponseEntity<Response> delete(@PathVariable long idOldCity) {
        cityService.deleteCity(idOldCity);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }
}
