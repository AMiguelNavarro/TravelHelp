package com.tfg.travelhelp.controller;

import com.tfg.travelhelp.domain.EmergencyPhone;
import com.tfg.travelhelp.domain.Language;
import com.tfg.travelhelp.dto.ILanguageProjection;
import com.tfg.travelhelp.service.languaje.ILanguageService;
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
@Tag(name = "Languages", description = "Listado de idiomas")
public class LanguageController implements ControllersMethods<Language> {

    @Autowired
    private ILanguageService languageService;


    @Operation(summary = "Obtiene un listado con todos los idiomas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Listado de idiomas", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Language.class))))
    })
    @GetMapping(value = "/language", produces = "application/json")
    @Override
    public ResponseEntity<List<Language>> getAll() {
        List<Language> languageList = languageService.findAllLanguages();
        return new ResponseEntity<>(languageList, HttpStatus.OK);
    }


    @Operation(summary = "Añade un nuevo idioma")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201" , description = "Se añade correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Language.class)))),
            @ApiResponse(responseCode = "409" , description = "El idioma ya existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @PostMapping(value = "/language", produces = "application/json")
    @Override
    public ResponseEntity<Language> addNew(@RequestBody Language newLanguage) {
        val language = languageService.addNewLanguage(newLanguage);
        return new ResponseEntity<>(language, HttpStatus.CREATED);
    }


    @Operation(summary = "Modifica un idioma")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201" , description = "Se modifica correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Language.class)))),
            @ApiResponse(responseCode = "404" , description = "El idioma a modificar no existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @PutMapping(value = "/language/{id}", produces = "application/json")
    @Override
    public ResponseEntity<Language> modify(@PathVariable long id, @RequestBody Language newLanguage) {
        val language = languageService.modifyLanguage(id, newLanguage);
        return new ResponseEntity<>(language, HttpStatus.OK);
    }


    @Operation(summary = "Elimina un idioma")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Se elimina correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class)))),
            @ApiResponse(responseCode = "404" , description = "El idioma a eliminar no existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @DeleteMapping(value = "/language/{id}", produces = "application/json")
    @Override
    public ResponseEntity<Response> delete(@PathVariable long id) {
        languageService.deleteLanguage(id);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }



    @Operation(summary = "Obtiene los idiomas de un país")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Listado de teléfonos de emergencias de un país", content = @Content(array = @ArraySchema(schema = @Schema(implementation = EmergencyPhone.class))))
    })
    @GetMapping(value = "/language/idCountry/{idCountry}", produces = "application/json")
    public ResponseEntity<List<ILanguageProjection>> findLanguageFromCountry(@PathVariable long idCountry) {
        List<ILanguageProjection> listLanguages = languageService.findLanguageFromCountry(idCountry);
        return new ResponseEntity<>(listLanguages, HttpStatus.OK);
    }
}
