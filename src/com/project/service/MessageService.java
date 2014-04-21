package com.project.service;

import java.util.List;

import com.project.dao.MessageDao;
import com.project.javabean.Message;

public class MessageService {
	
	MessageDao dao = new MessageDao();

	public boolean addMessage(Message m) throws Exception {
		return dao.addMessage(m);
	}
	
	public boolean deleteMessageByMessageId(int message_id) throws Exception {
		return dao.deleteMessageByMessageId(message_id);
	}
	
	public int getMessageTotalNum() throws Exception {
		return dao.getMessageTotalNum();
	}
	
	public List<Message> listAllMessageOrderByMessageId(int begin, int offset) throws Exception{
		return dao.listAllMessageOrderByMessageId(begin, offset);
	}

}
