package com.finartz.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by promegalex on 16.03.2020 13:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirLineRegionId {
    private int zipCode;
    private String cityName;
}
