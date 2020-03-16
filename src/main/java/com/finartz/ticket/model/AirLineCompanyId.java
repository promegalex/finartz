package com.finartz.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Created by promegalex on 11.03.2020 18:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirLineCompanyId {
    private UUID id;
    private String name;
}
