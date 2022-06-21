package edu.lnut.dao;
import edu.lnut.po.User;
public interface UserDao
{
    public User findUserFilm(String userName);
    public User findUserEmail(String userEmail);
}