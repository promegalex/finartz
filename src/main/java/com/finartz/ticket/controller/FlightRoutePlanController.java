package com.finartz.ticket.controller;

import com.finartz.ticket.model.FlightRoutePlan;
import com.finartz.ticket.model.FlightRoutePlanId;
import com.finartz.ticket.service.FlightRoutePlanService;
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
@RequestMapping(value = {"/flightRoute"}, produces = "application/json;charset=UTF-8")
@Api(value = "Flight Route Plan Controller Api")
public class FlightRoutePlanController extends AbstractController {
    private final FlightRoutePlanService flightRoutePlanService;

    @Autowired
    public FlightRoutePlanController(FlightRoutePlanService flightRoutePlanService) {
        this.flightRoutePlanService = flightRoutePlanService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getFlightRoutePlans() {
        List<FlightRoutePlan> flightRoutePlanList = flightRoutePlanService.getAll();
        return createResponse(flightRoutePlanList, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getFlightRoutePlan(@RequestParam("uuid") UUID uuid, @RequestParam("name") String name) {
        FlightRoutePlanId flightRoutePlanId = new FlightRoutePlanId(uuid, name);
        Optional<FlightRoutePlan> flightRoutePlan = flightRoutePlanService.get(flightRoutePlanId);
        return createResponse(flightRoutePlan.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> saveFlightRoutePlan(@RequestBody FlightRoutePlan flightRoutePlan) {
        flightRoutePlanService.save(flightRoutePlan);
        return createResponse("Flight Route Plan successfully registered", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> updateFlightRoutePlan(@RequestBody FlightRoutePlan flightRoutePlan) {
        flightRoutePlanService.update(flightRoutePlan);
        return createResponse("Flight Route Plan successfully updated", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteFlightRoutePlan(@RequestParam("uuid") UUID uuid, @RequestParam("name") String name) {
        FlightRoutePlanId flightRoutePlanId = new FlightRoutePlanId(uuid, name);
        flightRoutePlanService.delete(flightRoutePlanId);
        return createResponse("Flight Route Plan successfully deleted", HttpStatus.OK);
    }
}
