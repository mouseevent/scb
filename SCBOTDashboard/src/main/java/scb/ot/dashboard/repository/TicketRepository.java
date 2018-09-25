package scb.ot.dashboard.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import scb.ot.dashboard.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
	
	@Query("select t from Ticket t where t.applyDate > ?1 and t.applyDate< ?2")
	List<Ticket> findByDateRange(Date from, Date to);

	@Query("select t from Ticket t, User u where u.teamId = t.team.teamId and u.userId = ?1 and t.applyDate > ?2 and t.applyDate< ?3")
	List<Ticket> findByTeamAndDateRange(String userId, Date from, Date to);

	@Query("select t from Ticket t, User u where u.teamId = t.team.teamId and u.userId = ?1 ")
	List<Ticket> findByUser(String userId);
}
