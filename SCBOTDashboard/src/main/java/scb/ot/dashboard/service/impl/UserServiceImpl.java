package scb.ot.dashboard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import scb.ot.dashboard.entity.User;
import scb.ot.dashboard.repository.UserRepository;
import scb.ot.dashboard.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findUserByUserId(String userId) {
		return userRepository.findByUserId(userId);
	}

	@Override
	public User findUserByUserIdAndPassword(String userId, String password) {
		return userRepository.findByUserIdAndPassword(userId, password);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

}
