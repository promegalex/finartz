package com.finartz.ticket.controller;

import com.finartz.ticket.model.Ticket;
import com.finartz.ticket.model.TicketId;
import com.finartz.ticket.service.TicketService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by promegalex on 12.03.2020 18:33
 */
@RestController
@RequestMapping(value = {"/ticket"}, produces = "application/json;charset=UTF-8")
@Api(value = "Ticket Controller Api")
public class TicketController extends AbstractController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getTickets() {
        List<Ticket> tickets = ticketService.getAll();
        return createResponse(tickets, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getTicket(@RequestParam("uuid") UUID uuid, @RequestParam("name") String name) {
        TicketId ticketId = new TicketId(uuid, name);
        Optional<Ticket> ticket = ticketService.get(ticketId);
        return createResponse(ticket.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> buyTicket(@RequestBody Ticket ticket) {
        ticketService.create(ticket);
        return createResponse("Airline Company successfully registered", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> updateTicket(@RequestBody Ticket ticket) {
        ticketService.update(ticket);
        return createResponse("Airline Company successfully updated", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteTicket(@RequestParam("uuid") UUID uuid, @RequestParam("name") String name) {
        TicketId ticketId = new TicketId(uuid, name);
        ticketService.delete(ticketId);
        return createResponse("Airline Company successfully deleted", HttpStatus.OK);
    }
}
