package edu.hbuas.service.impl;

import edu.hbuas.dao.TopicDao;
import edu.hbuas.dao.impl.TopicDaoImpl;
import edu.hbuas.entity.Topic;
import edu.hbuas.service.TopicService;

import java.util.List;

public class TopicServiceImpl implements TopicService {
    //添加dao曾依赖
    TopicDao topicDao=new TopicDaoImpl();
    @Override
    public List<Topic> getalltopic() {

        return topicDao.getalltopic();
    }

    @Override
    public int deletebytopic(int tid) {
        return topicDao.deletebytid(tid);
    }

	@Override
	public boolean addtopic(Topic topic) {
		// TODO Auto-generated method stub
		return topicDao.addtopic(topic)>0;
	}

	@Override
	public Topic getbytid(int tid) {
		// TODO Auto-generated method stub
		return topicDao.gettopicbytid(tid);
	}

	@Override
	public boolean updatetopic(Topic topic) {
		// TODO Auto-generated method stub
		
		return topicDao.updatetopic(topic)>0;
	}

	@Override
	public Topic getbytname(String tname) {
		// TODO Auto-generated method stub
		return topicDao.gettopicbytname(tname);
	}

}
