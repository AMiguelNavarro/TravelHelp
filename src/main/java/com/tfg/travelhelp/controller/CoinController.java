package com.tfg.travelhelp.controller;

import com.tfg.travelhelp.domain.Coin;
import com.tfg.travelhelp.domain.Electricity;
import com.tfg.travelhelp.service.coin.ICoinService;
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
@Tag(name = "Coins", description = "Listado de monedas")
public class CoinController implements ControllersMethods<Coin> {

    @Autowired
    private ICoinService coinService;


    @Operation(summary = "Obtiene un listado con todos las monedas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Listado de monedas", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Coin.class))))
    })
    @GetMapping(value = "/coin", produces = "application/json")
    @Override
    public ResponseEntity<List<Coin>> getAll() {
        List<Coin> coinList = coinService.finAllCoins();
        return new ResponseEntity<>(coinList, HttpStatus.OK);
    }


    @Operation(summary = "Añade una nueva moneda")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201" , description = "Se añade correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Coin.class)))),
            @ApiResponse(responseCode = "409" , description = "La moneda ya existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @PostMapping(value = "/coin", produces = "application/json")
    @Override
    public ResponseEntity<Coin> addNew(@RequestBody Coin newCoin) {
        val coin = coinService.addNewCoin(newCoin);
        return new ResponseEntity<>(coin, HttpStatus.CREATED);
    }


    @Operation(summary = "Modifica una moneda")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201" , description = "Se modifica correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Coin.class)))),
            @ApiResponse(responseCode = "404" , description = "La moneda a modificar no existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @PutMapping(value = "/coin/{id}", produces = "application/json")
    @Override
    public ResponseEntity<Coin> modify(@PathVariable long id, @RequestBody Coin newCoin) {
        val coin = coinService.modifyCoin(id, newCoin);
        return new ResponseEntity<>(coin, HttpStatus.OK);
    }


    @Operation(summary = "Elimina una moneda")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" , description = "Se elimina correctamente", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class)))),
            @ApiResponse(responseCode = "404" , description = "La moneda a eliminar no existe", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Response.class))))
    })
    @DeleteMapping(value = "/coin/{id}", produces = "application/json")
    @Override
    public ResponseEntity<Response> delete(@PathVariable long id) {
        coinService.deleteCoin(id);
        return new ResponseEntity<>(Response.noErrorResponse(), HttpStatus.OK);
    }
}
