package org.example.db.bean;

import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.example.db.service.SampleDao;

public class DatabaseOperations {
	private SampleDao sampleDao;

	public SampleDao getSampleDao() {
		return sampleDao;
	}

	public void setSampleDao(SampleDao sampleDao) {
		this.sampleDao = sampleDao;
	}
	
	
	public List<Map<String,String>> getDetails(Exchange exchange) throws Exception{
		List<Map<String,String>> configDetailList = null;
		String query = "Select * from student;";
		try {
			configDetailList = sampleDao.fetchData( query);
			System.out.println("Result : " + configDetailList);
		} catch (Exception e) {
			throw e;
		}
		return configDetailList;
	}
	
}
