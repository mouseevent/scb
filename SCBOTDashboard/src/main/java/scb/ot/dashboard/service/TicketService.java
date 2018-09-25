package scb.ot.dashboard.service;

import java.util.Date;
import java.util.List;

import scb.ot.dashboard.entity.Ticket;
import scb.ot.dashboard.entity.User;

public interface TicketService {
	Ticket findTicketById(Long id);
	void updateTicket(Ticket ticket);
	List<Ticket> findTicketsByUserAndDateRange(User user, Date from, Date to);
}
