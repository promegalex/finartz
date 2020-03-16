package com.finartz.ticket.service;

import com.finartz.ticket.exception.FinartzNotFoundException;
import com.finartz.ticket.exception.InvalidException;
import com.finartz.ticket.model.AirLineCompany;
import com.finartz.ticket.model.FlightRoutePlan;
import com.finartz.ticket.model.Ticket;
import com.finartz.ticket.model.TicketId;
import com.finartz.ticket.repository.FlightRoutePlanRepository;
import com.finartz.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by promegalex on 11.03.2020 18:37
 */
@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final FlightRoutePlanRepository flightRoutePlanRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository, FlightRoutePlanRepository flightRoutePlanRepository) {
        this.ticketRepository = ticketRepository;
        this.flightRoutePlanRepository = flightRoutePlanRepository;
    }

    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> get(TicketId ticketId) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        if (!optionalTicket.isPresent()) {
            throw new FinartzNotFoundException("Ticket Cannot be found");
        }
        return ticketRepository.findById(ticketId);
    }

    public void create(Ticket ticket) {
        TicketId ticketId = ticket.getId();
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        if (optionalTicket.isPresent()) {
            throw new InvalidException("Ticket already created.");
        }
        FlightRoutePlan flightRoutePlan = ticket.getFlightRoutePlan();
        AirLineCompany airLineCompany = ticket.getAirLineCompany();
        Map<FlightRoutePlan, Integer> flightRoutePlans = airLineCompany.getFlightRoutePlans();
        if (Objects.isNull(flightRoutePlans)) {
            throw new FinartzNotFoundException("Flight route plan Cannot be found");
        }

        Integer passengerCount = flightRoutePlans.get(flightRoutePlan);
        int salesTicketCount = flightRoutePlan.getSalesTicketCount();
        double amount = flightRoutePlan.getAmount();

        double calculatedTicketAmount = calculateTicketAmount(passengerCount, salesTicketCount, amount);
        flightRoutePlan.setAmount(calculatedTicketAmount);
        flightRoutePlanRepository.save(flightRoutePlan);

        ticketRepository.save(ticket);
    }

    private double calculateTicketAmount(Integer passengerCount, int salesTicketCount, double amount) {
        if (passengerCount % salesTicketCount > 10 && passengerCount % salesTicketCount < 20) {
            amount = amount * 1.1;
        } else if (passengerCount % salesTicketCount > 20 && passengerCount % salesTicketCount < 30) {
            amount = amount * 1.2;
        } else if (passengerCount % salesTicketCount > 30 && passengerCount % salesTicketCount < 40) {
            amount = amount * 1.3;
        } else if (passengerCount % salesTicketCount > 40 && passengerCount % salesTicketCount < 50) {
            amount = amount * 1.4;
        } else if (passengerCount % salesTicketCount > 50 && passengerCount % salesTicketCount < 60) {
            amount = amount * 1.5;
        } else if (passengerCount % salesTicketCount > 60 && passengerCount % salesTicketCount < 70) {
            amount = amount * 1.6;
        } else if (passengerCount % salesTicketCount > 70 && passengerCount % salesTicketCount < 80) {
            amount = amount * 1.7;
        } else if (passengerCount % salesTicketCount > 80 && passengerCount % salesTicketCount < 90) {
            amount = amount * 1.8;
        } else if (passengerCount % salesTicketCount > 90 && passengerCount % salesTicketCount < 100) {
            amount = amount * 1.9;
        }
        return amount;
    }

    public void update(Ticket ticket) {
        TicketId ticketId = ticket.getId();
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        if (!optionalTicket.isPresent()) {
            throw new FinartzNotFoundException("Ticket Cannot be found");
        }
        ticketRepository.save(ticket);
    }

    public void delete(TicketId ticketId) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        if (!optionalTicket.isPresent()) {
            throw new FinartzNotFoundException("Ticket Cannot be found");
        }
        ticketRepository.deleteById(ticketId);
    }
}
