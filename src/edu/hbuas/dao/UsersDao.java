package edu.hbuas.dao;

import java.util.List;

import edu.hbuas.entity.Users;

public interface UsersDao {
	Users login(String uname, String upwd);//登录功能
    List<Users> getallusers();//获取所有用户
}
