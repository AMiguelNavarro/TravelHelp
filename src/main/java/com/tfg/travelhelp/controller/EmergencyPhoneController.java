package com.tfg.travelhelp.controller;

import com.tfg.travelhelp.domain.City;
import com.tfg.travelhelp.domain.EmergencyPhone;
import com.tfg.travelhelp.dto.EmergencyPhoneDTO;
import com.tfg.travelhelp.service.emergencyPhone.IEmergencyPhoneService;
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
@Tag(name = "Emergency phones", description = "Listado de teléfonos de emergencias")
public class EmergencyPhoneController implements ControllersMethodsDTO<EmergencyPhone, EmergencyPhoneDTO> {

    @Autowired
    private IEmergencyPhoneService emergencyPhoneService;


    @Operation(summary = "Obtiene un listado con todos los teléfonos de emergencias")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Listado de teléfonos de emergencias", content = @Content(array = @ArraySchema(schema = @Schema(implementation = EmergencyPhone.class))))
    })
    @GetMapping(value = "/emergencyphone", produces = "application/json")
    @Override
    public ResponseEntity<List<EmergencyPhone>> getAll() {
        List<EmergencyPhone> emergencyPhonesList = emergencyPhoneService.findAllEmergencyPhones();
        return new ResponseEntity<>(emergencyPhonesList, HttpStatus.OK);
    }


    @Operation(summary = "Añade un nuevo teléfono de emergencia")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201" , description = "Se añade correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = EmergencyPhone.class)))),
            @ApiResponse(responseCode = "409" , description = "El teléfono ya existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @PostMapping(value = "/emergencyphone", produces = "application/json")
    @Override
    public ResponseEntity<EmergencyPhone> addNew(@RequestBody EmergencyPhoneDTO newEmergencyPhoneDto) {
        val emergencyPhone = emergencyPhoneService.addNewEmergencyPhone(newEmergencyPhoneDto);
        return new ResponseEntity<>(emergencyPhone, HttpStatus.CREATED);
    }


    @Operation(summary = "Modifica un teléfono de emergencia")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201" , description = "Se modifica correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = EmergencyPhone.class)))),
            @ApiResponse(responseCode = "404" , description = "El teléfono a modificar no existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @PutMapping(value = "/emergencyphone/{id}", produces = "application/json")
    @Override
    public ResponseEntity<EmergencyPhone> modify(@PathVariable long id, @RequestBody EmergencyPhoneDTO newEmergencyPhoneDto) {
        val emergencyPhone = emergencyPhoneService.modifyEmergencyPhone(id, newEmergencyPhoneDto);
        return new ResponseEntity<>(emergencyPhone, HttpStatus.OK);
    }


    @Operation(summary = "Elimina un teléfono de emergencia")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Se elimina correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class)))),
            @ApiResponse(responseCode = "404" , description = "El teléfono a eliminar no existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @DeleteMapping(value = "/emergencyphone/{id}", produces = "application/json")
    @Override
    public ResponseEntity<Response> delete(@PathVariable long id) {
        emergencyPhoneService.deleteEmergencyPhone(id);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }


    @Operation(summary = "Obtiene un listado con todos los teléfonos de emergencias de un país")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Listado de teléfonos de emergencias de un país", content = @Content(array = @ArraySchema(schema = @Schema(implementation = EmergencyPhone.class))))
    })
    @GetMapping(value = "/emergencyphone/idCountry/{idCountry}", produces = "application/json")
    public ResponseEntity<List<EmergencyPhone>> findEmergencyPhonesFromCountry(@PathVariable long idCountry) {
        List<EmergencyPhone> emergencyPhonesList = emergencyPhoneService.findEmergencyPhonesFromCountry(idCountry);
        return new ResponseEntity<>(emergencyPhonesList, HttpStatus.OK);
    }

}
