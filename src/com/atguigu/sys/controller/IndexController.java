package com.atguigu.sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.common.utils.PageInfoUtil;
import com.atguigu.sys.entity.Employee;
import com.atguigu.sys.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class IndexController {
	
	@Autowired
	private EmployeeService empService;
	
	
	@RequestMapping("/")
	public String index(){
		return "/index";
		
	}
	
	@RequestMapping("/emps/{pageNum}")
	public String getEmps(Model model,HttpServletRequest ruquest,@PathVariable("pageNum") int pageNum){
		
		PageHelper.startPage(pageNum, 1);
		List<Employee> employees = empService.getEmployee();
		//5代表显示几个数字页（上一页 1 ， 2 ，3下一页）//来自线上的修改再次修改
		
		PageInfo<Employee>  pageIfo = new PageInfo<Employee>(employees, 5);
	    String  pageStr = 	PageInfoUtil.getPageInfo(ruquest, pageIfo);
		model.addAttribute("pageStr",pageStr );
		model.addAttribute("employees", employees);
		return "/list";
	}
	
}
