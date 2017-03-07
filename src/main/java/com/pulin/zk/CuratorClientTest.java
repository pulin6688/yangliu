package com.pulin.zk;

import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;

import com.facebook.presto.jdbc.internal.guava.collect.Lists;

public class CuratorClientTest {
	
	 /** Zookeeper info */
    private static final String ZK_ADDRESS = "192.168.174.129:2181,192.168.174.129:2182,192.168.174.129:2183";
    private static final String ZK_PATH = "/zktest";
    
    // 1.Connect to zk
    static  CuratorFramework client = CuratorFrameworkFactory.newClient(ZK_ADDRESS,new RetryNTimes(10, 5000));
    {
    	client.start();
    	System.out.println("zk client start successfully!");
    }
    
    
    public static void main(String[] args) throws Exception {
    	List<CuratorFramework> list = Lists.newArrayList();
    	while(true){
    		CuratorFramework client = CuratorFrameworkFactory.newClient( ZK_ADDRESS,new RetryNTimes(10, 5000) );
    		client.start();
    		list.add(client);
        	Thread.sleep(2000);
        }
    	
    	//create();
        //modify();
       // delete();  
       // get();
        
        
    }
    
    
    
    public static void get()throws Exception {
    	  // 2.2 Get node and data
        print("ls", "/");
        print(client.getChildren().forPath("/"));
       // print("get", ZK_PATH);
       // print( client.getData().forPath(ZK_PATH) );
    }
    
    
    public static void create()throws Exception {
    	  // 2.Client API test
        // 2.1 Create node
        String data1 = "hello";
        print("create", ZK_PATH, data1);
        client.create().
                creatingParentsIfNeeded().
                forPath(ZK_PATH, data1.getBytes());
    }
    
   
    
    public static void modify()throws Exception {
        // 2.3 Modify data
        String data2 = "world";
        print("set", ZK_PATH, data2);
        client.setData().forPath( ZK_PATH, data2.getBytes() );
        print("get", ZK_PATH);
        print(client.getData().forPath(ZK_PATH));
  }
    
    public static void delete()throws Exception {
    	  // 2.4 Remove node
        print("delete", ZK_PATH);
        client.delete().forPath(ZK_PATH);
        print("ls", "/");
        print(client.getChildren().forPath("/"));
  }
    
    

    private static void print(String... cmds) {
        StringBuilder text = new StringBuilder("$ ");
        for (String cmd : cmds) {
            text.append(cmd).append(" ");
        }
        System.out.println(text.toString());
    }

    private static void print(Object result) {
        System.out.println(
                result instanceof byte[]
                    ? new String((byte[]) result)
                        : result);
    }
}
