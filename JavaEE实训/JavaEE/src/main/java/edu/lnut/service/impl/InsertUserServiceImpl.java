package edu.lnut.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.lnut.dao.UserRegisterDao;
import edu.lnut.po.User;
import edu.lnut.service.InsertUserService;@
Service("insertUserService")
public class InsertUserServiceImpl implements InsertUserService
{
	@Autowired
    UserRegisterDao userRegisterDao;
	@Override
    public void insertUser(User user)
    {
        // TODO Auto-generated method stub
        userRegisterDao.insertUser(user);
    }
}