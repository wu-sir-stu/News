package edu.hbuas.dao;

import java.util.List;

import edu.hbuas.entity.Users;

public interface UsersDao {
	Users login(String uname, String upwd);//登录功能
    List<Users> getallusers();//获取所有用户
    int ExistUser(String uname);//判断用户名是否存在
    List<Users> getuser(String keyname);//根据用户关键字获取用户名
}
