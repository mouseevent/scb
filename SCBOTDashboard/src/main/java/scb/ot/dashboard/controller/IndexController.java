package scb.ot.dashboard.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import scb.ot.dashboard.config.AuthenticationInterceptor;
import scb.ot.dashboard.entity.Ticket;
import scb.ot.dashboard.entity.User;
import scb.ot.dashboard.service.TicketService;
import scb.ot.dashboard.utils.UserRoleUtils;

@RestController
public class IndexController {
	private static Logger logger = Logger.getLogger(IndexController.class);
	@Autowired
	private TicketService service;
	@Value("${dealine.day:5}")
	private Integer deadLineDay;

	@RequestMapping("/")
	public ModelAndView listTickets(HttpSession session) {
		User user = (User) session.getAttribute(AuthenticationInterceptor.SESSION_KEY);
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("allowsEdit", UserRoleUtils.hasEditPermission(user));
		mv.addObject("beforeDeadLine", beforeDeadLine());
		return mv;
	}

	@RequestMapping("/list")
	public List<Ticket> list(HttpSession session) {
		User user = (User) session.getAttribute(AuthenticationInterceptor.SESSION_KEY);
		LocalDate now = new LocalDate();
		LocalDate monthStart = now.minusDays(now.getDayOfMonth());
		return service.findTicketsByUserAndDateRange(user, monthStart.toDate(), now.toDate());
	}

	
	//TODO, we should be able to convert directly into Ticket entity, however 
	// team value in the ticket is failing during json conevertion
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public void update(@RequestBody Map<String, String> map) {
		Long ticketId = Long.parseLong(map.get("ticketId").trim());
		Integer amount = Integer.parseInt(map.get("amount").trim());
		Ticket ticket = service.findTicketById(ticketId);
		if(null != ticket) {
			ticket.setAmount(amount);
			service.updateTicket(ticket);
		}
		logger.info("Ticket updated : " + ticket);
	}
	
	private boolean beforeDeadLine() {
		boolean isBeforeDeadLine = new LocalDate().getDayOfMonth() <= deadLineDay;
		logger.info("isBeforeDeadLine :  " + isBeforeDeadLine);
		return isBeforeDeadLine;
	}

}
