package org.practice.TicketBooking.controller;

import java.util.List;
import java.util.Optional;

import org.practice.TicketBooking.dao.Ticket;
import org.practice.TicketBooking.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
	Added By me Comment for GIT Testing...

*/


@RestController
@RequestMapping("/ticketbooking")
public class TicketBookingController {
	
	@Autowired
	TicketBookingService ticketBookingService;
	
	@RequestMapping(value = "/create/ticket", method=RequestMethod.POST)
	public Ticket createTicket(@RequestBody Ticket ticket) {
		System.out.println("================================ Inside Post Mothod=================================");
		System.out.println(ticket.getMovie_name() + " : "+ ticket.getName());
		return ticketBookingService.createTicket(ticket);
	}
	
	@RequestMapping(value = "/ticket/{id}")
	public Optional<Ticket> getTicket(@PathVariable("id") int id){
		System.out.println("ID is "+ id);
		System.out.println("================================ Inside get Mothod=================================");
		return ticketBookingService.getTicket(id);
	}
	
	@RequestMapping(value = "/getAllTickets", method = RequestMethod.GET)
	public List<Ticket> getAllTickets(){
		return ticketBookingService.getAllTickets();
	}
	
	@RequestMapping(value="/updateTicket", method = RequestMethod.PUT)
	public Ticket updateTicket(@RequestBody Ticket ticket) {
		return ticketBookingService.updateTicket(ticket);
	}
	
	@RequestMapping(value="/deleteTicket/{ticketId}", method = RequestMethod.DELETE)
	public void deleteTicket(@PathVariable("ticketId") int ticketId){
		ticketBookingService.deleteTicket(ticketId);
	}	
}
