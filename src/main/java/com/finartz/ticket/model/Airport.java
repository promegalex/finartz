package com.finartz.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;

/**
 * Created by promegalex on 11.03.2020 18:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Airport {
    private AirportId id;
    private int wayCount;
    private int airlineCompanyCount;
    private int gateCount;

    public String getName() {
        return id.getName();
    }

    public UUID getUUID() {
        return id.getId();
    }
}
