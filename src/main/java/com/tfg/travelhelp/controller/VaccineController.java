package com.tfg.travelhelp.controller;

import com.tfg.travelhelp.domain.EmergencyPhone;
import com.tfg.travelhelp.domain.Vaccine;
import com.tfg.travelhelp.dto.ILanguageProjection;
import com.tfg.travelhelp.dto.IVaccineProjection;
import com.tfg.travelhelp.service.vaccine.IVaccineService;
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
@Tag(name = "Vaccines", description = "Listado de vacunas")
public class VaccineController implements ControllersMethods<Vaccine> {

    @Autowired
    private IVaccineService vaccineService;


    @Operation(summary = "Obtiene un listado con todas las vacunas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Listado de vacunas", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Vaccine.class))))
    })
    @GetMapping(value = "/vaccine", produces = "application/json")
    @Override
    public ResponseEntity<List<Vaccine>> getAll() {
        List<Vaccine> vaccineList = vaccineService.findAllVaccines();
        return new ResponseEntity<>(vaccineList, HttpStatus.OK);
    }


    @Operation(summary = "Añade una nueva vacuna")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201" , description = "Se añade correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Vaccine.class)))),
            @ApiResponse(responseCode = "409" , description = "La vacuna ya existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @PostMapping(value = "/vaccine", produces = "application/json")
    @Override
    public ResponseEntity<Vaccine> addNew(@RequestBody Vaccine newVaccine) {
        val vaccine = vaccineService.addNewVaccine(newVaccine);
        return new ResponseEntity<>(vaccine, HttpStatus.CREATED);
    }


    @Operation(summary = "Modifica una vacuna")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201" , description = "Se modifica correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Vaccine.class)))),
            @ApiResponse(responseCode = "404" , description = "La vacuna a modificar no existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @PutMapping(value = "/vaccine/{id}", produces = "application/json")
    @Override
    public ResponseEntity<Vaccine> modify(@PathVariable long id, @RequestBody Vaccine newVaccine) {
        val vaccine = vaccineService.modifyVaccine(id, newVaccine);
        return new ResponseEntity<>(vaccine, HttpStatus.OK);
    }


    @Operation(summary = "Elimina una vacuna")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Se elimina correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class)))),
            @ApiResponse(responseCode = "404" , description = "La vacuna a eliminar no existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @DeleteMapping(value = "/vaccine/{id}", produces = "application/json")
    @Override
    public ResponseEntity<Response> delete(@PathVariable long id) {
        vaccineService.deleteVaccine(id);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }



    @Operation(summary = "Obtiene las vacunas un país")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Listado de vacunas de un país", content = @Content(array = @ArraySchema(schema = @Schema(implementation = EmergencyPhone.class))))
    })
    @GetMapping(value = "/vaccine/idCountry/{idCountry}", produces = "application/json")
    public ResponseEntity<List<IVaccineProjection>> findVaccinesFromCountry(@PathVariable long idCountry) {
        List<IVaccineProjection> listVaccines = vaccineService.findVaccinesFromCountry(idCountry);
        return new ResponseEntity<>(listVaccines, HttpStatus.OK);
    }
}
