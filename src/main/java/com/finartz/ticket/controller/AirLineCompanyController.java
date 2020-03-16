package com.finartz.ticket.controller;

import com.finartz.ticket.model.AirLineCompany;
import com.finartz.ticket.model.AirLineCompanyId;
import com.finartz.ticket.service.AirLineCompanyService;
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
@RequestMapping(value = {"/airline"}, produces = "application/json;charset=UTF-8")
@Api(value = "AirLine Company Controller Api")
public class AirLineCompanyController extends AbstractController {
    private final AirLineCompanyService airLineCompanyService;

    @Autowired
    public AirLineCompanyController(AirLineCompanyService airLineCompanyService) {
        this.airLineCompanyService = airLineCompanyService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAirlineCompanies() {
        List<AirLineCompany> airLineCompanies = airLineCompanyService.getAll();
        return createResponse(airLineCompanies, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getAirlineCompany(@RequestParam("uuid") UUID uuid,
                                                    @RequestParam("name") String name) {
        AirLineCompanyId airLineCompanyId = new AirLineCompanyId(uuid, name);
        Optional<AirLineCompany> airLineCompany = airLineCompanyService.get(airLineCompanyId);
        return createResponse(airLineCompany.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> saveAirlineCompany(@RequestBody AirLineCompany airLineCompany) {
        airLineCompanyService.save(airLineCompany);
        return createResponse("Airline Company successfully registered", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> updateAirlineCompany(@RequestBody AirLineCompany airLineCompany) {
        airLineCompanyService.update(airLineCompany);
        return createResponse("Airline Company successfully update", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteAirlineCompany(@RequestParam("uuid") UUID uuid,
                                                       @RequestParam("name") String name) {
        AirLineCompanyId airLineCompanyId = new AirLineCompanyId(uuid, name);
        airLineCompanyService.delete(airLineCompanyId);
        return createResponse("Airline Company successfully deleted", HttpStatus.OK);
    }
}
