package edu.hbuas.service.impl;

import edu.hbuas.dao.UsersDao;
import edu.hbuas.dao.impl.UsersDaoImpl;
import edu.hbuas.entity.Users;
import edu.hbuas.service.UsersService;

import java.util.List;

public class UsersServiceImpl implements UsersService {
    UsersDao usersDao=new UsersDaoImpl();

    @Override
    public Users login(String uname, String upwd) {
        return usersDao.login(uname,upwd);
    }

    @Override
    public List<Users> getallusers() {
        return usersDao.getallusers();
    }
}
