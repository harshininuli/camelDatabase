package org.example.db.service;

import java.util.List;
import java.util.Map;

public interface SampleDao {
		
	public List<Map<String,String>> fetchData(String query) throws Exception;

}
