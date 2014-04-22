package com.project.service;

import java.util.List;

import com.project.dao.CarpoolingDao;
import com.project.javabean.Carpooling;
import com.project.javabean.User;


public class CarpoolingService {

	CarpoolingDao dao = new CarpoolingDao();

	public boolean addCarpooling(Carpooling c) throws Exception {
		return dao.addCarpooling(c);
	}
	
	public boolean deleteCarpoolingByCarpoolingId(int carpooling_id) throws Exception {
		return dao.deleteCarpoolingByCarpoolingId(carpooling_id);
	}
	
	public int getCarpoolingTotalNum() throws Exception {
		return dao.getCarpoolingTotalNum();
	}
	
	public List<Carpooling> listAllCarpoolingOrderByCarpoolingId(int begin, int offset) throws Exception{
		return dao.listAllCarpoolingOrderByCarpoolingId(begin, offset);
	}
	
	public int getSecrchCarpoolingNumBySource(String keyWords) throws Exception{
		return dao.getSecrchCarpoolingNumBySource(keyWords);
	}
	
	public List<Carpooling> getSecrchCarpoolingBySource(String keyWords, int begin, int offset) throws Exception{
		return dao.getSecrchCarpoolingBySource(keyWords, begin, offset);
	}
	
	public int getSecrchCarpoolingNumByDestiny(String keyWords) throws Exception{
		return dao.getSecrchCarpoolingNumByDestiny(keyWords);
	}
	
	public List<Carpooling> getSecrchCarpoolingByDestiny(String keyWords, int begin, int offset) throws Exception{
		return dao.getSecrchCarpoolingByDestiny(keyWords, begin, offset);
	}
	
	public int getSecrchCarpoolingNumBySourceAndDestiny(String source,String destiny) throws Exception{
		return dao.getSecrchCarpoolingNumBySourceAndDestiny(source,destiny);
	}
	
	public List<Carpooling> getSecrchCarpoolingBySourceAndDestiny(String source,String destiny, int begin, int offset) throws Exception{
		return dao.getSecrchCarpoolingBySourceAndDestiny(source, destiny, begin, offset);
	}
	
	public Carpooling getCarpoolingByCarpoolingId(int carpooling_id) throws Exception {
		return dao.getCarpoolingByCarpoolingId(carpooling_id);
	}
	
	public boolean addPassanger(int carpooling_id) throws Exception {
		Carpooling c = dao.getCarpoolingByCarpoolingId(carpooling_id);
		int joined_passangers = c.getJoined_passangers();
		c.setJoined_passangers(joined_passangers+1);
		dao.modifyCarpooling(c);
		return true;
	}
	
	public List<Carpooling> listAllCarpoolings( ) throws Exception{
		return dao.listAllCarpoolings();
	}
}
