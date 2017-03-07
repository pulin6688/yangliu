package com.pulin.concurrent;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	
    TreeNode parent   = null; 
    List children = new ArrayList();
 
    public synchronized void addChild(TreeNode child){
        if(!this.children.contains(child)) {
            this.children.add(child);
            child.setParentOnly(this);
        }
    }
    public synchronized void addChildOnly(TreeNode child){
        if(!this.children.contains(child)){
            this.children.add(child);
        }
    }
    public synchronized void setParent(TreeNode parent){
        this.parent = parent;
        parent.addChildOnly(this);
    }
 
    public synchronized void setParentOnly(TreeNode parent){
        this.parent = parent;
    }
    
    
    
    
    public static void main(String[] args) {
    	TreeNode node = new TreeNode();
    	new Thread(new Runnable(){
    		public void run(){
    			node.setParent(node);
    		}
    	}).start();
    	
     	new Thread(new Runnable(){
    		public void run(){
    			node.addChild(node);
    		}
    	}).start();
    	
    	
	}
}

