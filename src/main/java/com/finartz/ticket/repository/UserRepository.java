package com.finartz.ticket.repository;

import com.finartz.ticket.model.User;
import com.finartz.ticket.model.UserId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by promegalex on 11.03.2020 18:36
 */
public interface UserRepository extends MongoRepository<User, UserId> {
}
