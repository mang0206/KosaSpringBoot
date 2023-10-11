package com.example.springedu.controller;

import java.util.List;

import com.example.springedu.dao.EmpMapper;
import com.example.springedu.domain.EmpVO;
import com.example.springedu.domain.PageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpController {
	@Autowired
    EmpMapper dao;
	
	@GetMapping("/empnum") // 수정
	public ModelAndView count() {
		ModelAndView mav = new ModelAndView();
		int num = dao.getAllDataNum();
		mav.addObject("num", num);
		mav.setViewName("empResult");
		return mav;
	}
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<EmpVO> list = dao.listAll();
		mav.addObject("list", list);
		mav.setViewName("empResult");
		return mav;
	}

	@GetMapping("/findEmp1")
	public ModelAndView findEmp1(@RequestParam(defaultValue="7788") int empno) {
		ModelAndView mav = new ModelAndView();
		EmpVO emp = dao.findEmp1(empno);
		if (emp == null)
			mav.addObject("msg", "사번이 "+empno+"인 직원은 없어요~~");
		else
			mav.addObject("emp", emp);
		mav.setViewName("empResult");
		return mav;
	}

	@GetMapping("/findEmp2")
	public ModelAndView findEmp2(String ename) {
		ModelAndView mav = new ModelAndView();
		EmpVO emp = dao.findEmp2(ename);
		if (emp == null)
			mav.addObject("msg", "성명이 "+ename+"인 직원은 없어요~~");
		else
			mav.addObject("emp", emp);
		mav.setViewName("empResult");
		return mav;
	}
	
	@GetMapping("/part")
	public ModelAndView part(PageDTO vo) {
		ModelAndView mav = new ModelAndView();
		List<EmpVO> list = dao.listPart(vo);
		mav.addObject("list", list);
		mav.setViewName("empResult");
		return mav;
	}
}
