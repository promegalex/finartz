package com.finartz.ticket.repository;

import com.finartz.ticket.model.FlightRoutePlan;
import com.finartz.ticket.model.FlightRoutePlanId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by promegalex on 11.03.2020 18:34
 */
public interface FlightRoutePlanRepository extends MongoRepository<FlightRoutePlan, FlightRoutePlanId> {
}
