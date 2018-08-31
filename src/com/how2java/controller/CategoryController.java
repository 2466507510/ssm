package com.how2java.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;
import com.how2java.util.Page;

@Controller
@RequestMapping("")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
//	@RequestMapping("/listCategory")
//	public ModelAndView listCategory(Page page) {
//		ModelAndView mav=new ModelAndView("listCategory");
//		List<Category> cs=categoryService.list(page);
//		int total=categoryService.total();
//		page.caculateLast(total);
//		
//		mav.addObject("cs", cs);
//		return mav;
//	}
	
	
	@RequestMapping("/listCategory")
	public ModelAndView listCategory(Page page) {
		ModelAndView mav=new ModelAndView("listCategory");
		PageHelper.offsetPage(page.getStart(), page.getCount());
		List<Category> cs=categoryService.list();
		int total=(int) new PageInfo<>(cs).getTotal();
		page.caculateLast(total);
		mav.addObject("cs",cs);
		return mav;
	}
	
	@RequestMapping("/editCategory")
	public ModelAndView editCategory(Category c) {
		Category category=categoryService.get(c.getId());
		ModelAndView mav=new ModelAndView("editCategory");
		System.out.println(category.getId()+"   "+category.getName());
		mav.addObject("c", category);
		return mav;
	}
	
	@RequestMapping("/updateCategory")
	public ModelAndView updateCategory(Category c) {
		System.out.println(c.getId()+"   "+c.getName());
		categoryService.update(c);
		ModelAndView mav=new ModelAndView("redirect:/listCategory");
		return mav;
	}
	
	@RequestMapping("/deleteCategory")
	public ModelAndView deleteCategory(Category c) {
		categoryService.delete(c.getId());
		ModelAndView mav=new ModelAndView("redirect:/listCategory");
		return mav;
	}
	
	@RequestMapping("/addCategory")
	public ModelAndView addCategory(Category c) {
		categoryService.add(c);
		ModelAndView mav=new ModelAndView("redirect:/listCategory");
		return mav;
	}
}
