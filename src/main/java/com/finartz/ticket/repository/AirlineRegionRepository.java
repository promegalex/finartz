package com.finartz.ticket.repository;

import com.finartz.ticket.model.AirLineRegion;
import com.finartz.ticket.model.AirLineRegionId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by promegalex on 16.03.2020 13:26
 */
public interface AirlineRegionRepository extends MongoRepository<AirLineRegion, AirLineRegionId> {
}
