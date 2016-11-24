package com.yangliu.presto;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.io.FileUtils;

public class Test {
	public static void main(String[] args) throws Exception{
		test();
	}
	
	public static void test() throws Exception{
		
		Class.forName("com.facebook.presto.jdbc.PrestoDriver");
        Connection connection = DriverManager.getConnection("jdbc:presto://test@172.16.30.21:9090/hive/calm_ods","root",null);   
        Statement stmt = connection.createStatement();
        ResultSet rs = null;
        int index=0;
        
        // D:/baiduwaimai/table.txt
//        String createTable = FileUtils.readFileToString(new File("D:/baiduwaimai/table.txt"), "gbk");
//        System.out.println(createTable);
        
        
        //create TABLE table_name
       // stmt.execute("create table partner_test as select * from trade where source in(4,16,17,18)");
        
        //DROP TABLE table_name
        //stmt.execute("DROP TABLE partner_test");
        
        //create view kpi_gateway as select * from trade where source in(4,16,17,18)
        //stmt.execute("create view kpi_gateway as select * from trade where source in(4,16,17,18)");
      
        //create or replace view kpi_gateway as select id from trade where source in(4,16,17,18)
       
        //String sql = FileUtils.readFileToString(new File("D:/baiduwaimai/sql_view.txt"), "gbk");
       
        //订单视图
        //String sql = "create or replace view kpi_gateway_trade as select id,source,trade_time,shop_identy,server_create_time,server_update_time from trade where source in(4,16,17,18) ";
        //stmt.execute(sql);
        
        //排队视图
       // String sql = "create or replace view  kpi_gateway_queue as select queueID,commercialID,createDateTime,queueSource from mysql.calm_test.queue where synFlag is not null and  queueSource is not null and queueSource in('23','25')";
        //stmt.execute(sql);
      
      
        
      
        
        rs = stmt.executeQuery("show tables");
        // rs = stmt.executeQuery("DESCRIBE trade");
        index=rs.getMetaData().getColumnCount();
        while (rs.next()) {
        	for(int i=1;i<=index;i++){
        		 System.out.print(rs.getString(i));
        	}
        	System.out.println();
        }
        
        System.out.println("=================================================");
        
        
        // D:/baiduwaimai/sql.txt
//      String sql = FileUtils.readFileToString(new File("D:/baiduwaimai/sql.txt"), "gbk");
//      System.out.println(sql);
        
        //查询视图的数据
       // rs = stmt.executeQuery("select * from kpi_gateway limit 10");
       // rs = stmt.executeQuery("select * from kpi_loyalty_coup_all limit 10");
        //rs = stmt.executeQuery("select amount,check_time from kpi_loyalty_expect_market_plan limit 100");
        //rs = stmt.executeQuery("select * from kpi_loyalty_expect_market_plan limit 100");
       
      	//rs = stmt.executeQuery("select commercialID from mysql.calm.test.queue limit 10");
        
        //rs = stmt.executeQuery("select count(1) from kpi_gateway_trade");
        rs = stmt.executeQuery("select count(1) from kpi_gateway_queue");
        //
      	//rs = stmt.executeQuery(sql);
      	
      	
        index=rs.getMetaData().getColumnCount();
        while (rs.next()) {
        	for(int i=1;i<=index;i++){
        		System.out.print(rs.getString(i)+"|");
        	}
        	System.out.println();
        }
        
        rs.close();
        
        
        stmt.close();
        connection.close();
	}
}
