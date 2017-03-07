package com.test;

public class Test {

	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			long s = System.currentTimeMillis();
			aa();
			long e = System.currentTimeMillis();
			System.out.println((e-s));
		}

	}
	
	public static void aa() {
		
		String str ="123xxa345nxyx,s123人用餐,sadfaf";
		Boolean flag = str.matches(".*\\d+人用餐.*");
		if(!flag){
			return;
		}
		String a = str.substring(0, str.indexOf("人用餐"));
		//System.out.println(a);
		char[] arr = a.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(int i=arr.length-1;i>=0;i--){
			char tt = arr[i];
			  int  ascii   =  tt;
			  if(ascii < 48 || ascii > 57){
				  break;
			  }else{
				  sb.append(tt);
			  }
		}
		arr = sb.toString().toCharArray();
		sb = new StringBuffer();
		for(int i=arr.length-1;i>=0;i--){
			char tt = arr[i];
			 sb.append(tt);
			
		}
		System.out.println(sb.toString());

	}
	
	public static boolean isNumeric(String str){
		  for(int i=str.length();--i>=0;){
		   int chr=str.charAt(i);
		   if(chr<48 || chr>57)
		     return false;
		  }
		  return true;
		}

}
