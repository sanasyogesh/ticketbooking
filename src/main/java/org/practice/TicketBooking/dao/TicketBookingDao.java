package org.practice.TicketBooking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketBookingDao extends CrudRepository<Ticket, Integer>{

}
