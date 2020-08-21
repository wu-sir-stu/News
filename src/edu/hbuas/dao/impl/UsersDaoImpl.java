package edu.hbuas.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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

		@Override
		public int ExistUser(String uname) {
			// TODO Auto-generated method stub
			int r=-1;
			String sql="select * from users where uname=?";
			Object[] params= {uname};
			List<Users> users=DBUtil2.Querybyuser(sql, params);
			r=users.size();
			return r;
		}

		@Override
		public List<Users> getuser(String keyname) {
			List<Users> users=new ArrayList<>();
	        Connection con=null;
	        PreparedStatement pre=null;
	        ResultSet rs=null;
	        String sql="select * from users where uname like ?";
	        try {
	            con=DBUtil2.getcon();
	            pre=con.prepareStatement(sql);
	            
	                    pre.setObject(1,keyname+"%");
	            
	            rs=pre.executeQuery();
	            while (rs.next()){
	                Users user=new Users();
	                user.setUid(rs.getInt("uid"));
	                user.setUname(rs.getString("uname"));
	                user.setUpwd(rs.getString("upwd"));

	                //System.out.println(user.toString());
	                users.add(user);
	            }
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally {
	        	DBUtil2.closeAll(con,pre,rs);

	        }
	        return users;
		}
}
