package com.finartz.ticket.repository;

import com.finartz.ticket.model.Airport;
import com.finartz.ticket.model.AirportId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by promegalex on 11.03.2020 18:34
 */
public interface AirportRepository extends MongoRepository<Airport, AirportId> {
}
