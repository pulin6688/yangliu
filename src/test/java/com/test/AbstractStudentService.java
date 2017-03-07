package com.test;

public abstract  class AbstractStudentService implements IStudentService{
	public String getName(int id) {  
        return "ATY";  
    }  
  
    public abstract int getAge(int id); 
}
