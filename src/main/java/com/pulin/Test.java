package com.pulin;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

public class Test {
	public static void main(String[] args) {
		Person p = new Person();
		List<Integer>  list = p.getList();
		list.add(1);
		list.remove(0);
		System.out.println(p.getList().toString());
		
		
		
		//=====================================================
		Map<String,Map<String,String>> map = new HashMap<String,Map<String,String>>();
		for(int i=1;i<=10;i++){
			if(map.get("test") != null){
				map.get("test").put("sub"+String.valueOf(i)+"key", String.valueOf(i) );
			}else{
				Map<String,String> subMap = new HashMap<String,String>();
				subMap.put("sub"+String.valueOf(i)+"key", String.valueOf(i));
				map.put("test", subMap);
				
			}
		}
		Map<String,String> subMap = map.get("test");
		subMap = null;
		//map.put("test", null);
		System.out.println(map.get("test").toString());
		
		
		//=====================================================
		String s = "123abc";
		s.replaceAll("\\d", "");
		System.out.println(s);
		Integer i = 2;
		i=i.sum(i, 2);
		System.out.println("i:"+i);
		
		
		//===========================================================
		List<String> ll = Lists.newArrayList();
		ll.add("a");
		ll.add("ab");
		ll.add("abc");
	
		
		List<String> output = ll.stream().map(String::toUpperCase).collect(Collectors.toList());
		
		ll.stream().forEach(a -> System.out.println(a));
		output.stream().forEach(ss -> System.out.println(ss));
		//Arrays.stream(output.toArray()).forEach(ss -> System.out.println(ss));
		//ll.stream().filter(filed->{});
		
		File file = new File("D:/code_pulin/yangliu/src/main");
		
		Arrays.stream(file.listFiles()).forEach(f -> System.out.println(f.getName()));
		
		Arrays.stream(file.listFiles())
		.filter(f -> f.getName().endsWith("webapp"))
		.forEach(f -> System.out.println(f.isFile()));
		
		 List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		  
		 numbers.stream().filter((x) -> {return x % 2 == 0;})
		    	  .map((x) -> { return x * x;})
		    	  .forEach(System.out::println);
		  
		 List<Integer> numbers2 = numbers.stream().filter((x) ->  {return x % 2 == 0;})
    	 .map((x) -> { return x * x;}).collect(Collectors.toList());
		  
		  numbers2.stream().forEach(n-> {System.out.println(n);});
		  
		  
		  //=========================
		  //=========================
		  //http://ifeve.com/stream/
		  //=========================
		  //=========================
		  //of方法：有两个overload方法，一个接受变长参数，一个接口单一值
		  Stream<Integer> integerStream = Stream.of(1, 2, 3, 5);
		  Stream<String> stringStream = Stream.of("taobao");

		  
		  //generator方法：生成一个无限长度的Stream，其元素的生成是通过给定的Supplier（这个接口可以看成一个对象的工厂，每次调用返回一个给定类型的对象）
		  Stream.generate(new Supplier<Double>() {
			      public Double get() {
			          return Math.random();
			      }
			  });
			  Stream.generate(() -> Math.random());
			  Stream.generate(Math::random);
			  
			  
			  // iterate方法：也是生成无限长度的Stream，和generator不同的是，其元素的生成是重复对给定的种子值(seed)调用用户指定函数来生成的。其中包含的元素可以认为是：seed，f(seed),f(f(seed))无限循环
			  Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);


		
	}
	
	public static void r() {
		File f = new File("D:/code_pulin/yangliu/src/main");
		Arrays.stream(f.listFiles()).forEach(file -> System.out.println(file.getName()));
		
		//FileFilter java = (File f) -> f.getName().endsWith("*.java");
	}
	
//	public void s(){
//		(int x, int y) -> x + y
//		() -> 42
//		(String s) -> { System.out.println(s); }
//	}
	
	
	static class Person{
		private String name;
		private List<Integer> list = Lists.newArrayList();

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Integer> getList() {
			return list;
		}

		public void setList(List<Integer> list) {
			this.list = list;
		}
	}
}
