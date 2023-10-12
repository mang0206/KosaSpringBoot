package com.example.springlab.controller;

import com.example.springlab.dao.BookMapper;
import com.example.springlab.domain.BookDTO;
import com.example.springlab.domain.BookResultVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
  @Autowired
  BookMapper dao;

  @RequestMapping("/book/main")
  public String main(){
    return "bookPage";
  }

  @RequestMapping("/book/b1")
  public ModelAndView info(){
    ModelAndView mav = new ModelAndView();
    List<BookDTO> list = dao.list();

    mav.addObject("list", list);
    mav.setViewName("bookPage");

    return mav;
  }

  @RequestMapping("/book/b2")
  public ModelAndView sortList(){
    ModelAndView mav = new ModelAndView();
    List<BookDTO> list = dao.sortList();

    mav.addObject("list", list);
    mav.setViewName("bookPage");

    return mav;
  }

  @RequestMapping("/book/b3")
  public ModelAndView overList(){
    ModelAndView mav = new ModelAndView();
    List<BookDTO> list = dao.overList();

    mav.addObject("list", list);
    mav.setViewName("bookPage");

    return mav;
  }

  @RequestMapping("/book/b4")
  public ModelAndView webBookList(){
    ModelAndView mav = new ModelAndView();
    List<BookDTO> list = dao.webBookList();

    mav.addObject("list", list);
    mav.setViewName("bookPage");

    return mav;
  }

  @RequestMapping("/book/b5")
  public ModelAndView dbAndInfraList(){
    ModelAndView mav = new ModelAndView();
    List<BookDTO> list = dao.dbAndInfraList();

    mav.addObject("list", list);
    mav.setViewName("bookPage");

    return mav;
  }

  @RequestMapping("/book/b6")
  public ModelAndView javaList(){
    ModelAndView mav = new ModelAndView();
    List<BookDTO> list = dao.javaList();

    mav.addObject("list", list);
    mav.setViewName("bookPage");

    return mav;
  }

  @RequestMapping("/book/b7")
  public ModelAndView avgList(){
    ModelAndView mav = new ModelAndView();
    List<BookResultVO> list = dao.avgList();

    mav.addObject("list", list);
    mav.setViewName("bookPage");

    return mav;
  }

  @PostMapping("/bookCreate")
  public ModelAndView insert(BookDTO dto){
    ModelAndView mav = new ModelAndView();
    boolean result = dao.insert(dto);

    if(result)
      mav.addObject("list", dao.list());
    else
      mav.addObject("msg", "글 등록에 실패했습니다.");
    mav.setViewName("bookPage");
    return mav;
  }
}
