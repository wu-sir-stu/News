package edu.hbuas.dbutil;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import edu.hbuas.entity.Users;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBUtil2 {
	//static ComboPooledDataSource datasource=new ComboPooledDataSource("mysql");
    /**
     * 获取连接
     * @return
     */
	
    public static Connection getcon(){
		//DataSource ds=null;
		Connection con=null;
        try {
            //ds=new ComboPooledDataSource("mysql");
            con=JDBCUtil.getIns().getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 通用增删改方法
     * @param sql
     * @param params
     * @return
     */
    public static int executeUpdate(String sql,Object[] params){
        Connection con=null;
        PreparedStatement pre=null;
        int r=-1;
        try {
            con=getcon();
            pre=con.prepareStatement(sql);
            //给占位符传值
            if (params!=null){
                for (int i=0;i<params.length;i++){
                    pre.setObject(i+1,params[i]);
                }
            }
            r=pre.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
        	closeAll(con, pre, null);
        }
        return r;
    }

    /**
     * 用户表通用查询方法
     * @param sql
     * @param params
     * @return
     */
    public static List<Users> Querybyuser(String sql,Object... params){
        List<Users> users=new ArrayList<>();
        Connection con=null;
        PreparedStatement pre=null;
        ResultSet rs=null;
        try {
            con=getcon();
            pre=con.prepareStatement(sql);
            if (params!=null){
                for (int i=0;i<params.length;i++){
                    pre.setObject(i+1,params[i]);
                }
            }
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
            closeAll(con,pre,rs);

        }
        return users;
    }

    /**
     * 通用关闭连接方法
     * @param connection
     * @param preparedStatement
     * @param resultSet
     */
    public static void closeAll(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        try{

            if (resultSet!=null){
                resultSet.close();
            }
            if (preparedStatement!=null){
                preparedStatement.close();
            }
            if (connection!=null){
                connection.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
