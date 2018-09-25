package scb.ot.dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import scb.ot.dashboard.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserId(String userId);

	@Query("select u from User u, Authenticate a where u.userId =?1 and a.userId=?1 and a.password=?2")
	User findByUserIdAndPassword(String userId, String password);
}
