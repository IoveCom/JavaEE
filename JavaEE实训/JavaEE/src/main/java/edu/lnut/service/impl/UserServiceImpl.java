package edu.lnut.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.lnut.dao.UserDao;
import edu.lnut.po.User;
import edu.lnut.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{
@Autowired
UserDao userDao;
	@Override
	public User findUserInfo(String userName) {
		return userDao.findUserFilm(userName);
	}
	@Override
	public User findUserEmail(String userEmail) {
		// TODO Auto-generated method stub
		return userDao.findUserEmail(userEmail);
	}
	

}
