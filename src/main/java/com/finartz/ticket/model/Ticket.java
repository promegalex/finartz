package com.finartz.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Created by promegalex on 11.03.2020 18:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private TicketId id;
    private FlightRoutePlan flightRoutePlan;
    private double amount;
    private UUID serialKey;
    private AirLineCompany airLineCompany;

    public String getName() {
        return id.getName();
    }

    public UUID getUUID() {
        return id.getId();
    }
}