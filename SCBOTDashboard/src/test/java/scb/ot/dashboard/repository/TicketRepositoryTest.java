package scb.ot.dashboard.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import scb.ot.dashboard.entity.Ticket;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TicketRepositoryTest {
	@Autowired
	private TicketRepository repository;
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	private static Logger logger = Logger.getLogger(TicketRepositoryTest.class);

	@Test
	@Sql("classpath:db/tables.ddl.sql")
	@Sql("classpath:db/data_insert.sql")
	public void testQuery() {
		try {
			Date from = format.parse("2018-09-01");
			Date to = format.parse("2018-09-01");
			List<Ticket> tickets = repository.findByUser("admin");
			assertNotNull(tickets);
			assertEquals(1, tickets.size());
			Ticket ticket = tickets.get(0);
			assertEquals("Admin Team", ticket.getTeamName());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.toString());
		}

	}

}
