package com.finartz.ticket.repository;

import com.finartz.ticket.model.Ticket;
import com.finartz.ticket.model.TicketId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by promegalex on 11.03.2020 18:35
 */
public interface TicketRepository extends MongoRepository<Ticket, TicketId> {
}
