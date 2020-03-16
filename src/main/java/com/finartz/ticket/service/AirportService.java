package com.finartz.ticket.service;


import com.finartz.ticket.exception.FinartzNotFoundException;
import com.finartz.ticket.exception.InvalidException;
import com.finartz.ticket.model.Airport;
import com.finartz.ticket.model.AirportId;
import com.finartz.ticket.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by promegalex on 11.03.2020 18:36
 */
@Service
public class AirportService {
    private final AirportRepository airportRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> getAll() {
        return airportRepository.findAll();
    }

    public Optional<Airport> get(AirportId airportId) {
        Optional<Airport> optionalAirport = airportRepository.findById(airportId);
        if (!optionalAirport.isPresent()) {
            throw new FinartzNotFoundException("Airport Cannot be found");
        }
        return optionalAirport;
    }

    public void save(Airport airport) {
        AirportId airportId = airport.getId();
        Optional<Airport> optionalAirport = airportRepository.findById(airportId);
        if (optionalAirport.isPresent()) {
            throw new InvalidException("Airport already created");
        }
        airportRepository.save(airport);
    }

    public void update(Airport airport) {
        AirportId airportId = airport.getId();
        Optional<Airport> optionalAirport = airportRepository.findById(airportId);
        if (!optionalAirport.isPresent()) {
            throw new FinartzNotFoundException("Airport Cannot be found");
        }
        airportRepository.save(airport);
    }

    public void delete(AirportId airportId) {
        Optional<Airport> optionalAirport = airportRepository.findById(airportId);
        if (!optionalAirport.isPresent()) {
            throw new FinartzNotFoundException("Airport Cannot be found");
        }
        airportRepository.deleteById(airportId);
    }
}
