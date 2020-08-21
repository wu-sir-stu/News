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

	@Override
	public boolean ExistUser(String uname) {
		// TODO Auto-generated method stub
		return usersDao.ExistUser(uname)>0;
	}

	@Override
	public String getuser(String keyname) {
		// TODO Auto-generated method stub
		List<Users> users=usersDao.getuser(keyname);
		String name="";
		if(users.size()>0) {
			for (Users u : users) {
				name+=u.getUname()+",";
			}
		}
		return name.substring(0,name.length()-1);//去掉逗号
	}
}
