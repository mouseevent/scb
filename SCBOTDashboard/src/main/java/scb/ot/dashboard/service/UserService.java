package scb.ot.dashboard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import scb.ot.dashboard.entity.User;

@Service
public interface UserService {

	User findUserByUserId(String userId);

	User findUserByUserIdAndPassword(String userId, String password);

	List<User> findAll();
}
