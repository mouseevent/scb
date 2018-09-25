package scb.ot.dashboard.repository;

import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import scb.ot.dashboard.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository repository;

	private static Logger logger = Logger.getLogger(UserRepositoryTest.class);

	@Test
	@Sql("classpath:db/tables.ddl.sql")
	@Sql("classpath:db/data_insert.sql")
	public void testLogin() {
		assertNotNull(repository);
		User user = repository.findByUserIdAndPassword("jd1000", "jd1000");
		assertNotNull(user);
	}

	@Test
	@Sql("classpath:db/tables.ddl.sql")
	@Sql("classpath:db/data_insert.sql")
	public void testRole() {
		User user = repository.findByUserId("ad1001");
		assertNotNull(user);
		logger.info(user);
		assertNotNull(user.getRole());
//		assertTrue(user.isAdmin());

	}

}
