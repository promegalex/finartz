package com.finartz.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by promegalex on 11.03.2020 18:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserId {
    private String name;
    private String surName;
    private String personalId;
}
