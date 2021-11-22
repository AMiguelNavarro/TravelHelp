package com.tfg.travelhelp.controller;

import com.tfg.travelhelp.domain.Electricity;
import com.tfg.travelhelp.domain.EmergencyPhone;
import com.tfg.travelhelp.domain.Plug;
import com.tfg.travelhelp.service.electricity.IElectricityService;
import com.tfg.travelhelp.utils.ControllersMethods;
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
@Tag(name = "Electricities", description = "Listado de electricidad")
public class ElectricityController implements ControllersMethods<Electricity> {

    @Autowired
    IElectricityService electricityService;


    @Operation(summary = "Obtiene un listado con todos los tipos de electricidad")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Listado de electricidad", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Electricity.class))))
    })
    @GetMapping(value = "/electricity", produces = "application/json")
    @Override
    public ResponseEntity<List<Electricity>> getAll() {
        List<Electricity> electricityList = electricityService.findAllElectricities();
        return new ResponseEntity<>(electricityList, HttpStatus.OK);
    }


    @Operation(summary = "Añade una nueva electricidad")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201" , description = "Se añade correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Electricity.class)))),
            @ApiResponse(responseCode = "409" , description = "La electricidad ya existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @PostMapping(value = "/electricity", produces = "application/json")
    @Override
    public ResponseEntity<Electricity> addNew(@RequestBody Electricity newElectricity) {
        val electricity = electricityService.addNewElectricity(newElectricity);
        return new ResponseEntity<>(electricity, HttpStatus.CREATED);
    }


    @Operation(summary = "Modifica una electricidad")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201" , description = "Se modifica correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Electricity.class)))),
            @ApiResponse(responseCode = "404" , description = "La electricidad a modificar no existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @PutMapping(value = "/electricity/{id}", produces = "application/json")
    @Override
    public ResponseEntity<Electricity> modify(@PathVariable long id, @RequestBody Electricity newElectricity) {
        val electricity = electricityService.modifyElectricity(id, newElectricity);
        return new ResponseEntity<>(electricity, HttpStatus.OK);
    }


    @Operation(summary = "Elimina una electricidad")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Se elimina correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class)))),
            @ApiResponse(responseCode = "404" , description = "La electricidad a eliminar no existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @DeleteMapping(value = "/electricity/{id}", produces = "application/json")
    @Override
    public ResponseEntity<Response> delete(@PathVariable long id) {
        electricityService.deleteElectricity(id);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }

    @Operation(summary = "Obtiene la electricidad de un país")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Electricidad de un país", content = @Content(array = @ArraySchema(schema = @Schema(implementation = EmergencyPhone.class))))
    })
    @GetMapping(value = "/electricity/idCountry/{idCountry}", produces = "application/json")
    public ResponseEntity<Electricity> findElectricityFromCountry(@PathVariable long idCountry) {
        Electricity electricity = electricityService.findElectricityFromCountry(idCountry);
        return new ResponseEntity<>(electricity, HttpStatus.OK);
    }
}
