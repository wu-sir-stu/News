package edu.hbuas.dao.impl;

import edu.hbuas.dao.NewsDao;
import edu.hbuas.dao.TopicDao;
import edu.hbuas.dbutil.DBUtil2;
import edu.hbuas.entity.News;
import edu.hbuas.entity.Topic;
import edu.hbuas.entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TopicDaoImpl implements TopicDao {
	NewsDao nd=new NewsDaoImpl();

    /**
     * 主题表通用查询方法
     * @param sql
     * @param params
     * @return
     */
    public static List<Topic> Querybytopic(String sql, Object... params){
        List<Topic> topics=new ArrayList<>();
        Connection con=null;
        PreparedStatement pre=null;
        ResultSet rs=null;
        try {
            con=DBUtil2.getcon();
            pre=con.prepareStatement(sql);
            if (params!=null){
                for (int i=0;i<params.length;i++){
                    pre.setObject(i+1,params[i]);
                }
            }
            rs=pre.executeQuery();
            while (rs.next()){
                Topic topic=new Topic();
                topic.setTid(rs.getInt("tid"));
                topic.setTname(rs.getString("tname"));

                //System.out.println(user.toString());
                topics.add(topic);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil2.closeAll(con,pre,rs);

        }
        return topics;
    }





    @Override
    public List<Topic> getalltopic() {
        String sql="select * from topic";

        List<Topic> alltopic= Querybytopic(sql);


        return alltopic;
    }

    @Override
    public int deletebytid(int tid) {
    	//1.获取news表中是否使用该主题
    	List<News> ntidnews=nd.getnewsbyntid(tid);
    	if(ntidnews.size()>0) {
    		return -1;
    	}else {
    		String sql="delete from topic where tid=?";
            Object[] params={tid};
            int r=DBUtil2.executeUpdate(sql,params);

            return r;
    	}
        
    }





	@Override
	public int addtopic(Topic topic) {
		// TODO Auto-generated method stub
		String sql="insert into topic value (?,?)";
		Object[] params= {null,topic.getTname()};
		int r=DBUtil2.executeUpdate(sql, params);
		return r;
	}





	@Override
	public int updatetopic(Topic topic) {
		// TODO Auto-generated method stub
		String sql="update topic set tname=? where tid=?";
		Object[] params= {topic.getTname(),topic.getTid()};
		int r=DBUtil2.executeUpdate(sql, params);
		return r;
	}





	@Override
	public Topic gettopicbytid(int tid) {
		// TODO Auto-generated method stub
		Topic topic=null;
		String sql="select * from topic where tid=?";
		Object[] params= {tid};
		List<Topic> topics=Querybytopic(sql, params);
		if(topics.size()>0) {
			topic=topics.get(0);
			
		}
		return topic;
		
	}





	@Override
	public Topic gettopicbytname(String tname) {
		// TODO Auto-generated method stub
		Topic topic=null;
		String sql="select * from topic where tname=?";
		Object[] params= {tname};
		List<Topic> topics=Querybytopic(sql, params);
		if(topics.size()>0) {
			topic=topics.get(0);
			
		}
		return topic;
	}
}
