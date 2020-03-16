package com.finartz.ticket.repository;

import com.finartz.ticket.model.AirLineCompany;
import com.finartz.ticket.model.AirLineCompanyId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by promegalex on 11.03.2020 18:33
 */
public interface AirLineCompanyRepository extends MongoRepository<AirLineCompany, AirLineCompanyId> {
}
