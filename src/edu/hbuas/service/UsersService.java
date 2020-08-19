package edu.hbuas.service;

import edu.hbuas.entity.Users;

import java.util.List;

public interface UsersService {
    Users login(String uname,String upwd);//登录功能
    List<Users> getallusers();//获取所有用户
}
