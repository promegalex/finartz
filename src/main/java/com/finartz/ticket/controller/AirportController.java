package com.finartz.ticket.controller;

import com.finartz.ticket.model.Airport;
import com.finartz.ticket.model.AirportId;
import com.finartz.ticket.service.AirportService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by promegalex on 11.03.2020 18:32
 */
@RestController
@RequestMapping(value = {"/airport"}, produces = "application/json;charset=UTF-8")
@Api(value = "Airport Controller Api")
public class AirportController extends AbstractController {
    private final AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAirports() {
        List<Airport> airports = airportService.getAll();
        return createResponse(airports, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getAirport(@RequestParam("uuid") UUID uuid, @RequestParam("name") String name) {
        AirportId airportId = new AirportId(uuid, name);
        Optional<Airport> airport = airportService.get(airportId);
        return createResponse(airport.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> saveAirport(@RequestBody Airport airport) {
        airportService.save(airport);
        return createResponse("Airport successfully registered", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> updateAirport(@RequestBody Airport airport) {
        airportService.update(airport);
        return createResponse("Airport successfully updated", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteAirport(@RequestParam("uuid") UUID uuid, @RequestParam("name") String name) {
        AirportId airportId = new AirportId(uuid, name);
        airportService.delete(airportId);
        return createResponse("Airport successfully deleted", HttpStatus.OK);
    }
}
