package org.practice.TicketBooking.service;

import java.util.List;
import java.util.Optional;

import org.practice.TicketBooking.dao.Ticket;
import org.springframework.stereotype.Service;

@Service
public interface TicketBookingService {

	public Ticket createTicket(Ticket ticket);
	public Optional<Ticket> getTicket(int id);
	public List<Ticket> getAllTickets();
	public Ticket updateTicket(Ticket ticket);
	public void deleteTicket(int ticketId);
}
