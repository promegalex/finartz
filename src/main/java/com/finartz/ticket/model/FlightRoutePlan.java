package com.finartz.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

/**
 * Created by promegalex on 11.03.2020 18:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightRoutePlan {
    private FlightRoutePlanId id;
    private Date departureTime;
    private AirLineCompany airLineCompany;
    private AirLineRegion departureFrom;
    private AirLineRegion arriveTo;
    private int salesTicketCount;
    private double amount;

    public String getName() {
        return id.getName();
    }

    public UUID getUUID() {
        return id.getId();
    }
}
