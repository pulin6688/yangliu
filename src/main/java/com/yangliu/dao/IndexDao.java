package com.yangliu.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Repository
public class IndexDao {
	
	private static Logger logger = LoggerFactory.getLogger(IndexDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String,Object>> find(String sql){
		logger.info("IndexDao start...");
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Map<String,Object>>>(){
			public List<Map<String,Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {
				ResultSetMetaData meta = rs.getMetaData();
				List<String> list = Lists.newArrayList();
				for(int i=1;i<=meta.getColumnCount();i++){
					//String name = meta.getColumnName(i);//列实际名称
					String name = meta.getColumnLabel(i);//列别名
					//System.out.print(name+",");
					//System.out.println(meta.getColumnClassName(i));
					list.add(name);
					
				}
				List<Map<String,Object>> values = Lists.newArrayList();
				while(rs.next()){
					Map<String,Object> map = Maps.newHashMap();
					for(String name : list){
						Object value = rs.getObject(name);
						map.put(name, value);
					}
					values.add(map);
				}
				return values;
			}
			
		});
	}
}
