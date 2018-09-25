package scb.ot.dashboard.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scb.ot.dashboard.entity.Ticket;
import scb.ot.dashboard.entity.User;
import scb.ot.dashboard.repository.TicketRepository;
import scb.ot.dashboard.service.TicketService;
import scb.ot.dashboard.utils.UserRoleUtils;

@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	private TicketRepository repository;

	@Override
	public Ticket findTicketById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void updateTicket(Ticket ticket) {
		repository.saveAndFlush(ticket);
	}

	@Override
	public List<Ticket> findTicketsByUserAndDateRange(User user, Date from, Date to) {
		if (UserRoleUtils.hasReadAllPermission(user)) {
			return repository.findByDateRange(from, to);
		} else {
			return repository.findByTeamAndDateRange(user.getUserId(), from, to);
		}
	}
}
