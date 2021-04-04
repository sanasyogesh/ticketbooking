package org.practice.TicketBooking.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.practice.TicketBooking.dao.Ticket;
import org.practice.TicketBooking.dao.TicketBookingDao;
import org.practice.TicketBooking.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketBookingServiceImpl implements TicketBookingService {

	@Autowired
	TicketBookingDao ticketBookingDao;
	
	@Override
	public Ticket createTicket(Ticket ticket) {
		return ticketBookingDao.save(ticket);
	}

	@Override
	public Optional<Ticket> getTicket(int id) {
		return ticketBookingDao.findById(id);
	}

	@Override
	public List<Ticket> getAllTickets() {
		return (List<Ticket>) ticketBookingDao.findAll();
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		Ticket existingTicket = ticketBookingDao.findById(ticket.getId()).orElse(null);
 		
		if(existingTicket != null) {
			existingTicket.setName(ticket.getName());
			existingTicket.setMovie_name(ticket.getMovie_name());
			existingTicket.setRating(ticket.getRating());			
		}else {
			return ticketBookingDao.save(ticket);
		}				
		return ticketBookingDao.save(existingTicket);
	}

	@Override
	public void deleteTicket(int ticketId) {
		ticketBookingDao.deleteById(ticketId);		
	}	
}
