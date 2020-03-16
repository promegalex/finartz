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
public class TicketId {
    private UUID id;
    private String name;
}
