package edu.hbuas.service;

import edu.hbuas.entity.Users;

import java.util.List;

public interface UsersService {
    Users login(String uname,String upwd);//登录功能
    List<Users> getallusers();//获取所有用户
    boolean ExistUser(String uname);//判断用户名是否存在
    String getuser(String keyname);//根据用户关键字获取用户名
}
