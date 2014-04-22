package com.project.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.project.dao.LogDao;
import com.project.javabean.Carpooling;
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
	
	public TreeMap<String,Integer> getCarpoolingSources() throws Exception{
		TreeMap<String,Integer> map  =  new  TreeMap<String,Integer>();
		CarpoolingService carpoolingService = new CarpoolingService();
		List<Carpooling> carpoolings = new ArrayList<Carpooling>();
		carpoolings = carpoolingService.listAllCarpoolings();
		for(int i=0;i<carpoolings.size();i++){
			String source = carpoolings.get(i).getSource();
			Integer value = map.get(source);
			int count = 1;
			if( value!=null){
				count = value+1;
			}
			map.put(source,count);
		}
		return map;
	}

	public TreeMap<String,Integer> getCarpoolingDestinies() throws Exception{
		TreeMap<String,Integer> map  =  new  TreeMap<String,Integer>();
		CarpoolingService carpoolingService = new CarpoolingService();
		List<Carpooling> carpoolings = new ArrayList<Carpooling>();
		carpoolings = carpoolingService.listAllCarpoolings();
		for(int i=0;i<carpoolings.size();i++){
			String destiny = carpoolings.get(i).getDestiny();
			Integer value = map.get(destiny);
			int count = 1;
			if( value!=null){
				count = value+1;
			}
			map.put(destiny,count);
		}
		Iterator <Entry<String,Integer>>  it  =  map.entrySet().iterator();
		return map;
	}
}
