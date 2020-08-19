package edu.hbuas.dao.impl;

import java.util.List;

import edu.hbuas.dao.UsersDao;
import edu.hbuas.dbutil.DBUtil2;
import edu.hbuas.entity.Users;

public class UsersDaoImpl implements UsersDao {
	 @Override
	    public Users login(String uname, String upwd) {
	        Users user=null;
	        Object[] params={uname,upwd};
	        String sql="select * from users where uname=? and upwd=?";
	        List<Users> users= DBUtil2.Querybyuser(sql,params);
	        if (users.size()>0){
	            user=users.get(0);
	            //System.out.println(user.toString());
	            return user;
	        }else {
	            return user;
	        }

	    }

	    @Override
	    public List<Users> getallusers() {
	        List<Users> allusers=null;
	        Object[] params={};
	        String sql="select * from users";
	        allusers=DBUtil2.Querybyuser(sql);

	        return allusers;
	    }
}
