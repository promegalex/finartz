package com.finartz.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * Created by promegalex on 11.03.2020 18:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private UserId id;
    private List<Ticket> tickets;
    private String phoneNumber;
    private String address;
    private Date birthDate;
    private Gender gender;
}
