package edu.hbuas.service;

import edu.hbuas.entity.Topic;

import java.util.List;

public interface TopicService {
    List<Topic> getalltopic();//获取所有的topic
    int deletebytopic(int tid);
    boolean addtopic(Topic topic);
    Topic getbytid(int tid);
    boolean updatetopic(Topic topic);
    Topic getbytname(String tname);
}
