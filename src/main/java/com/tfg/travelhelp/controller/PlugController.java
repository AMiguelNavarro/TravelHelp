package com.tfg.travelhelp.controller;

import com.tfg.travelhelp.domain.Plug;
import com.tfg.travelhelp.service.plug.IPlugService;
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
@Tag(name = "Plugs", description = "Listado de enchufes")
public class PlugController implements ControllersMethods<Plug> {

    @Autowired
    private IPlugService plugService;

    @Operation(summary = "Obtiene un listado con todos los enchufes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Listado de enchufes", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Plug.class))))
    })
    @GetMapping(value = "/plug", produces = "application/json")
    @Override
    public ResponseEntity<List<Plug>> getAll() {
        List<Plug> plugList = plugService.findAllPlugs();
        return new ResponseEntity<>(plugList, HttpStatus.OK);
    }


    @Operation(summary = "Añade un nuevo enchufe")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201" , description = "Se añade correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Plug.class)))),
            @ApiResponse(responseCode = "409" , description = "El enchufe ya existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @PostMapping(value = "/plug", produces = "application/json")
    @Override
    public ResponseEntity<Plug> addNew(@RequestBody Plug newPlug) {
        val plug = plugService.addNewPlug(newPlug);
        return new ResponseEntity<>(plug, HttpStatus.CREATED);
    }


    @Operation(summary = "Modifica un enchufe")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201" , description = "Se modifica correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Plug.class)))),
            @ApiResponse(responseCode = "404" , description = "el enchufe a modificar no existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @PutMapping(value = "/plug/{id}", produces = "application/json")
    @Override
    public ResponseEntity<Plug> modify(@PathVariable long id, @RequestBody Plug newPlug) {
        val plug = plugService.modifyPlug(id, newPlug);
        return new ResponseEntity<>(plug, HttpStatus.OK);
    }


    @Operation(summary = "Elimina un enchufe")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Se elimina correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class)))),
            @ApiResponse(responseCode = "404" , description = "El enchufe a eliminar no existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @DeleteMapping(value = "/plug/{id}", produces = "application/json")
    @Override
    public ResponseEntity<Response> delete(@PathVariable long id) {
        plugService.deletePlug(id);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }
}
