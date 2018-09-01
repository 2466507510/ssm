package com.how2java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.how2java.pojo.Category;

@Controller
@RequestMapping("")
public class CategoryJsonController {
	
	@ResponseBody
	@RequestMapping("/submitCategory")
	public String submitCategory(@RequestBody Category category) {
		System.out.println("SSM接收到浏览器提交的json，并转换为Category对象："+category);
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping("/getOneCategory")
	public String getOneCategory() {
		Category c=new Category();
		c.setId(1000);
		c.setName("第1000个分类");
		JSONObject json=new JSONObject();
		json.put("category", JSONObject.toJSON(c));
		return json.toJSONString();
	}
	
	
	@ResponseBody
	@RequestMapping("/getManyCategory")
	public String getManyCategory() {
		List<Category> cs=new ArrayList<Category>();
		for(int i=1;i<=10;i++) {
			Category c=new Category();
			c.setId(i);
			c.setName("第"+i+"个分类");
			cs.add(c);
		}
		
		return JSONObject.toJSON(cs).toString();
	}
}
