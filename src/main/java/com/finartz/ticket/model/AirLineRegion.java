package com.finartz.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by promegalex on 12.03.2020 21:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirLineRegion {
    private AirLineRegionId id;
    private String phoneNumber;
    private String localTime;
    private String centralAddress;
    private List<String> flightTo;
}
