package com.finartz.ticket.service;

import com.finartz.ticket.exception.FinartzNotFoundException;
import com.finartz.ticket.exception.InvalidException;
import com.finartz.ticket.model.FlightRoutePlan;
import com.finartz.ticket.model.FlightRoutePlanId;
import com.finartz.ticket.repository.FlightRoutePlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by promegalex on 11.03.2020 18:37
 */
@Service
public class FlightRoutePlanService {
    private final FlightRoutePlanRepository flightRoutePlanRepository;

    @Autowired
    public FlightRoutePlanService(FlightRoutePlanRepository flightRoutePlanRepository) {
        this.flightRoutePlanRepository = flightRoutePlanRepository;
    }

    public List<FlightRoutePlan> getAll() {
        return flightRoutePlanRepository.findAll();
    }

    public Optional<FlightRoutePlan> get(FlightRoutePlanId flightRoutePlanId) {
        Optional<FlightRoutePlan> optionalFlightRoutePlan = flightRoutePlanRepository.findById(flightRoutePlanId);
        if (!optionalFlightRoutePlan.isPresent()) {
            throw new FinartzNotFoundException("Flight Route Plan Cannot be found");
        }
        return flightRoutePlanRepository.findById(flightRoutePlanId);
    }

    public void save(FlightRoutePlan flightRoutePlan) {
        FlightRoutePlanId flightRoutePlanId = flightRoutePlan.getId();
        Optional<FlightRoutePlan> optionalFlightRoutePlan = flightRoutePlanRepository.findById(flightRoutePlanId);
        if (optionalFlightRoutePlan.isPresent()) {
            throw new InvalidException("Flight Route Plan already created");
        }
        flightRoutePlanRepository.save(flightRoutePlan);
    }

    public void update(FlightRoutePlan flightRoutePlan) {
        FlightRoutePlanId flightRoutePlanId = flightRoutePlan.getId();
        Optional<FlightRoutePlan> optionalFlightRoutePlan = flightRoutePlanRepository.findById(flightRoutePlanId);
        if (!optionalFlightRoutePlan.isPresent()) {
            throw new FinartzNotFoundException("Flight Route Plan Cannot be found");
        }
        flightRoutePlanRepository.save(flightRoutePlan);
    }

    public void delete(FlightRoutePlanId flightRoutePlanId) {
        Optional<FlightRoutePlan> optionalFlightRoutePlan = flightRoutePlanRepository.findById(flightRoutePlanId);
        if (!optionalFlightRoutePlan.isPresent()) {
            throw new FinartzNotFoundException("Flight Route Plan Cannot be found");
        }
        flightRoutePlanRepository.deleteById(flightRoutePlanId);
    }
}
