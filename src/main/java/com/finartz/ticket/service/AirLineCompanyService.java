package com.finartz.ticket.service;

import com.finartz.ticket.exception.FinartzNotFoundException;
import com.finartz.ticket.exception.InvalidException;
import com.finartz.ticket.model.AirLineCompany;
import com.finartz.ticket.model.AirLineCompanyId;
import com.finartz.ticket.repository.AirLineCompanyRepository;
import com.finartz.ticket.repository.AirlineRegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by promegalex on 11.03.2020 18:36
 */
@Service
public class AirLineCompanyService {
    private final AirLineCompanyRepository airLineCompanyRepository;
    private final AirlineRegionRepository airlineRegionRepository;

    @Autowired
    public AirLineCompanyService(AirLineCompanyRepository airLineCompanyRepository, AirlineRegionRepository airlineRegionRepository) {
        this.airLineCompanyRepository = airLineCompanyRepository;
        this.airlineRegionRepository = airlineRegionRepository;
    }

    public List<AirLineCompany> getAll() {
        return airLineCompanyRepository.findAll();
    }

    public Optional<AirLineCompany> get(AirLineCompanyId airLineCompanyId) {

        Optional<AirLineCompany> optionalAirLineCompany = airLineCompanyRepository.findById(airLineCompanyId);
        if (!optionalAirLineCompany.isPresent()) {
            throw new FinartzNotFoundException("Airline Company Cannot be found");
        }
        return airLineCompanyRepository.findById(airLineCompanyId);
    }

    public void save(AirLineCompany airLineCompany) {
        AirLineCompanyId airLineCompanyId = airLineCompany.getId();
        Optional<AirLineCompany> optionalAirLineCompany = airLineCompanyRepository.findById(airLineCompanyId);
        if (optionalAirLineCompany.isPresent()) {
            throw new InvalidException("Airline Company already created");
        }
        airLineCompanyRepository.save(airLineCompany);
    }

    public void update(AirLineCompany airLineCompany) {
        AirLineCompanyId airLineCompanyId = airLineCompany.getId();
        Optional<AirLineCompany> optionalAirLineCompany = airLineCompanyRepository.findById(airLineCompanyId);
        if (!optionalAirLineCompany.isPresent()) {
            throw new FinartzNotFoundException("Airline Company Cannot be found");
        }
        airLineCompanyRepository.save(airLineCompany);
    }

    public void delete(AirLineCompanyId airLineCompanyId) {
        Optional<AirLineCompany> optionalAirLineCompany = airLineCompanyRepository.findById(airLineCompanyId);
        if (!optionalAirLineCompany.isPresent()) {
            throw new FinartzNotFoundException("Airline Company Cannot be found");
        }
        airLineCompanyRepository.deleteById(airLineCompanyId);
    }
}
