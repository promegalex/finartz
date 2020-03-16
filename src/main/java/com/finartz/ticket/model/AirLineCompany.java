package com.finartz.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by promegalex on 11.03.2020 18:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirLineCompany {
    private AirLineCompanyId id;
    private List<AirLineRegion> airLineRegions;
    private Map<FlightRoutePlan, Integer> flightRoutePlans;

    private String getName() {
        return id.getName();
    }

    private UUID getUUID() {
        return id.getId();
    }
}

