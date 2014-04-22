package com.project.service;

import com.project.dao.LogDao;
import com.project.javabean.Log;

public class LogService {
	LogDao dao = new LogDao();
	
	public boolean addLog() throws Exception {
		Log log = new Log();
		//For test.
		String ip = "127.0.0.1";
		log.setIp(ip);
		return dao.addLog(log);
	}
	
	public int getLogTotalNum() throws Exception {
		return dao.getLogTotalNum();
	}

}
