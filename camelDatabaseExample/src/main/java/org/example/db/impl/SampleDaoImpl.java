package org.example.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.example.db.service.SampleDao;

public class SampleDaoImpl implements SampleDao {
	
	private String serviceName;
	
	private DataSource defaultDataSource;
	
	public DataSource getDefaultDataSource() {
		return defaultDataSource;
	}

	public void setDefaultDataSource(DataSource defaultDataSource) {
		this.defaultDataSource = defaultDataSource;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	
	

	@Override
	public List<Map<String, String>> fetchData(String query) throws Exception {
		List<Map<String,String>> configDetailList = null;
		Map<String,String> configDetailMap = null;
		try(Connection connection = defaultDataSource.getConnection();
				PreparedStatement pStatement = connection.prepareStatement(query);) {
			try(ResultSet rs = pStatement.executeQuery();) {
				ResultSetMetaData rsmd = rs.getMetaData();
				configDetailList = new ArrayList<>();
				while (rs.next()) {
					configDetailMap = new HashMap<String, String>();
					for(int i=1; i<=rsmd.getColumnCount(); i++){
						configDetailMap.put(rsmd.getColumnName(i), rs.getString(i));
					}
					configDetailList.add(configDetailMap);
				}
			}catch (SQLException e) {
				throw e;
			}
			return configDetailList;
		}
		catch (SQLException e) {
			throw e;
		} 
	}

}
