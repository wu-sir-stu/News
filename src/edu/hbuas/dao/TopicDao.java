package edu.hbuas.dao;

import edu.hbuas.entity.Topic;

import java.util.List;

public interface TopicDao {
    List<Topic> getalltopic();//获取所有的主题
    int deletebytid(int tid);//根据tid删除主题
    int addtopic(Topic topic);//添加主题
    Topic gettopicbytid(int tid);//根据id获取topic
    int updatetopic(Topic topic);//跟新topic
    Topic gettopicbytname(String tname);//根据tname获取topic
}
