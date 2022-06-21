package edu.lnut.service;
/*
 * 查询用户信息Service:例如添加用户和登录
 * */
import edu.lnut.po.User;

public interface UserService {
	public User findUserInfo(String userName);
	public User findUserEmail(String userEmail);
}
