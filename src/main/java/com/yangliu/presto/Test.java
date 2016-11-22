package com.yangliu.presto;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.io.FileUtils;

public class Test {
	public static void main(String[] args) throws Exception{
		Class.forName("com.facebook.presto.jdbc.PrestoDriver");
        Connection connection = DriverManager.getConnection("jdbc:presto://test@172.16.30.21:9090/hive/calm_ods","root",null);   
        Statement stmt = connection.createStatement();
       
        // D:/baiduwaimai/table.txt
//        String createTable = FileUtils.readFileToString(new File("D:/baiduwaimai/table.txt"), "gbk");
//        System.out.println(createTable);
        
        //stmt.execute("CREATE TABLE partner_test AS SELECT * FROM trade");
        
        //DROP TABLE table_name
        //stmt.execute("DROP TABLE partner_test");
        
        
        
        ResultSet rs = stmt.executeQuery("show tables");
        //ResultSet rs = stmt.executeQuery("DESCRIBE trade");
        //DESCRIBE table_name
        int index=rs.getMetaData().getColumnCount();
        while (rs.next()) {
        	for(int i=1;i<=index;i++){
        		 System.out.print(rs.getString(i));
        	}
        	System.out.println();
           
        }
        
        System.out.println("=================================================");
        
        rs = stmt.executeQuery("select * from partner_test limit 100");
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
