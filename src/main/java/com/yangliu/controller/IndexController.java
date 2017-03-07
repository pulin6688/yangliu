package com.yangliu.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.yangliu.service.IndexService;

@Controller
@RequestMapping("api")
public class IndexController {
	
	@Autowired
	private IndexService indexService;
	
	@RequestMapping(value = "getCache", method ={ RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Object getCache(@RequestParam(name="no",required=false) Integer no,@RequestParam(name="size",required=false) Integer size){
		return indexService.findByCache(no,size);
	}
	
	@RequestMapping(value = "get", method ={ RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Object get(@RequestParam(name="no",required=false) Integer no,@RequestParam(name="size",required=false) Integer size){
		return indexService.find(no,size);
	}
	
	@RequestMapping(value = "test", method ={ RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Object test(@RequestParam(name="no",required=false) Integer no,@RequestParam(name="size",required=false) Integer size){
		Map<String,Object> map = Maps.newHashMap();
		map.put("name","yangliu");
		map.put("time", System.currentTimeMillis());
		map.put("t", new Random().nextDouble()*10);	
		return map;
	}
	
	@RequestMapping(value = "message", method ={ RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public Object message(@RequestParam(name="size",required=false) Integer size){
		return indexService.message(size);
	}

}
